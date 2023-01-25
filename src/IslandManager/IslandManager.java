package IslandManager;

import Config.AliveOrganismConfiguration.AliveOrganismConfiguration;
import Config.AliveOrganismConfiguration.AliveOrganismConfigurationLoader;
import Config.Configurator;
import Config.IslandManagerConfiguration.IslandManagerConfiguration;
import Config.IslandManagerConfiguration.IslandManagerConfigurationLoader;
import Island.Island;
import Island.Location.AliveOrganism.AliveOrganism;
import Island.Location.AliveOrganism.Animals.Animal;
import Island.Location.AliveOrganism.Animals.Herbivores.*;
import Island.Location.AliveOrganism.Animals.Moving.Move;
import Island.Location.AliveOrganism.Animals.Moving.MoveDirection;
import Island.Location.AliveOrganism.Animals.Predators.*;
import Island.Location.AliveOrganism.Plants.Shrub;
import Island.Location.Location;
import Island.Location.Locations;
import IslandManager.Exceptions.IslandManagerInterruptedException;
import IslandManager.Exceptions.IslandManagerSpawnAliveOrganismException;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.concurrent.*;

public class IslandManager {
    private static final int BIRTH_PERCENT_DIVIDER = 2;
    protected final IslandManagerConfigurationLoader loader;
    protected final IslandManagerConfiguration configuration;
    protected Island island;

    protected ExecutorService executorService = Executors.newCachedThreadPool();

    public IslandManager(IslandManagerConfigurationLoader loader) {
        this.loader = loader;
        this.configuration = loader.load();
        islandInitializer();
    }

    public void start() {
        spawnAliveOrganisms();
        if (configuration.getIsCycleDuringSomebodyALive()) {
            somebodyAliveCycle();
        } else {
            System.out.println("borderedCycle()");
            //borderedCycle();
        }
    }

    public static void main(String[] args) throws IOException {
        final IslandManager manager = new IslandManager(new IslandManagerConfigurationLoader("C:\\Users\\zzzif\\IdeaProjects\\Island4.0\\src\\Config\\properties.json"));
        manager.start();
    }

    protected void islandInitializer() {
        final int verticalLocationsCount = configuration.getVerticalLocationsCount();
        final int horizontalLocationsCount = configuration.getHorizontalLocationsCount();
        final Location[][] locationsArray = new Location[verticalLocationsCount][horizontalLocationsCount];
        fillLocations(locationsArray);
        final Locations locations = new Locations(locationsArray);
        this.island = new Island(locations);
    }

    protected void fillLocations(Location[][] locations) {
        for (int i = 0; i < locations.length; ++i) {
            for (int j = 0; j < locations[i].length; ++j) {
                locations[i][j] = new Location(new CopyOnWriteArrayList<>());
            }
        }
    }
    protected void spawnAliveOrganisms() {
        final Locations locations = island.getLocations();
        for (int i = 0; i < locations.getVerticalCount(); ++i) {
            for (int j = 0; j < locations.getHorizontalCount(i); ++j) {
                Location location = locations.get(i, j);
                spawnAliveOrganisms(location);
            }
        }
    }
    @SuppressWarnings({"rawtypes"})
    protected void spawnAliveOrganisms(Location location) {
        final Class[] aliveOrganismsClasses = new Class[]{Boar.class, Buffalo.class, Caterpillar.class, Deer.class, Duck.class, Goat.class, Horse.class, Mouse.class, Rabbit.class, Sheep.class, Bear.class, Boa.class, Eagle.class, Fox.class, Wolf.class, Shrub.class};
        for (final Class clazz : aliveOrganismsClasses) {
            final AliveOrganismConfigurationLoader loader = Configurator.getAliveOrganismConfiguratorLoader();
            try {
                Constructor constructor = clazz.getDeclaredConstructor(AliveOrganismConfigurationLoader.class);
                AliveOrganism newOrganism = (AliveOrganism) constructor.newInstance(loader);
                AliveOrganismConfiguration newOrganismConfiguration = newOrganism.getConfiguration();
                final ThreadLocalRandom random = ThreadLocalRandom.current();
                final int newOrganismCount = random.nextInt(newOrganismConfiguration.getMaxOrganismConcentration());
                for (int i = 0; i < newOrganismCount; ++i) {
                    if (random.nextInt(101) < newOrganismConfiguration.getSpawnProbability()) {
                        location.addOrganism((AliveOrganism) constructor.newInstance(loader));
                    }
                }
                location.addOrganism(newOrganism);
            } catch (NoSuchMethodException | InvocationTargetException | InstantiationException |
                     IllegalAccessException e) {
                throw new IslandManagerSpawnAliveOrganismException(String.format("failed to spawn the AliveOrganism of %s class", clazz.getName()));
            }
        }
    }

    protected void somebodyAliveCycle() {
        while (somebodyAlive()) {
            aliveOrganismsProcessing();
            removingDeadOrganisms();
            makeAnimalsMoreHungry();
            removingDeadOrganisms();
            growingUpAliveOrganisms();
            reproducingAnimals();
            movingAnimals();
            spawnPlants();
            //sleep();
            printAliveOrganismsCount();
            System.out.println("#################################");
        }
    }

    private void printAliveOrganismsCount() {
        final Map<Class<?>, Integer> organismsCount = new HashMap<>();
        List<AliveOrganism> aliveOrganisms = new ArrayList<>();
        for (final Location location : island.getLocations()) {
            aliveOrganisms.addAll(location.getOrganisms());
        }
        aliveOrganisms.stream()
                .forEach(organism -> {
                    if (organismsCount.containsKey(organism.getClass())){
                        organismsCount.put(organism.getClass(), organismsCount.get(organism.getClass()) + 1);
                    } else {
                        organismsCount.put(organism.getClass(), 0);
                    }
                });
        for (final var entry : organismsCount.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    protected boolean somebodyAlive() {
        final Locations locations = island.getLocations();
        for (int i = 0; i < locations.getVerticalCount(); ++i) {
            for (int j = 0; j < locations.getHorizontalCount(i); ++j) {
                final List<AliveOrganism> organismList = locations.get(i, j).getOrganisms();
                for (final AliveOrganism organism : organismList) {
                    if (organism instanceof Animal && organism.isAlive()) return true;
                }
            }
        }
        return false;
    }
    protected void aliveOrganismsProcessing() {
        List<Callable<Void>> tasks = getAliveOrganismsProcessingTasks();
        try {
            executorService.invokeAll(tasks);
        } catch (InterruptedException e) {
            throw new IslandManagerInterruptedException("alive organisms processing was interrupted");
        }
    }
    protected void removingDeadOrganisms() {
        //System.out.println("Removing dead orgnisms");
        for (final Location location : island.getLocations()) {
            location.getOrganisms().removeIf(organism -> !organism.isAlive());
        }
    }
    protected void makeAnimalsMoreHungry() {
        //System.out.println("Animals digest food");
        for (final Location location : island.getLocations()) {
            for (final AliveOrganism organism : location.getOrganisms()) {
                if (organism instanceof Animal) {
                    ((Animal) organism).makeMoreHungry();
                }
            }
        }
    }
    protected void growingUpAliveOrganisms() {
        //System.out.println("Animals growing up");
        for (final Location location : island.getLocations()) {
            for (final AliveOrganism organism : location.getOrganisms()) {
                organism.growUp();
            }
        }
    }
    protected void reproducingAnimals() {
        //System.out.println("Animals reproducing");
        for (final Location location : island.getLocations()) {
            Set<Class<?>> reproducedAnimalsClasses = new HashSet<>();
            for (final AliveOrganism organism : location.getOrganisms()) {
                if (organism instanceof Animal) {
                    if (!reproducedAnimalsClasses.contains(organism.getClass())) {
                        reproducedAnimalsClasses.add(organism.getClass());
                        final int adultOrganismsCount = (int) location.getOrganisms()
                                .stream()
                                .filter(org -> org.getClass().equals(organism.getClass()))
                                .filter(AliveOrganism::isAdult)
                                .count();
                        final int countOfBabes = adultOrganismsCount / BIRTH_PERCENT_DIVIDER;
                        for (int i = 0; i < countOfBabes; ++i) {
                            location.addOrganism(((Animal) organism).reproduce());
                        }
                    }
                }
            }
        }
    }
    protected void movingAnimals() {
        //System.out.println("Animals moving");
        Locations locations = island.getLocations();
        for (int i = 0; i < locations.getVerticalCount(); ++i) {
            for (int j = 0; j < locations.getHorizontalCount(i); ++j) {
                final Location location = locations.get(i, j);
                List<Animal> locationAnimals = location.getOrganisms()
                        .stream()
                        .filter(organism -> organism instanceof Animal)
                        .map(organism -> (Animal) organism)
                        .toList();
                for (final Animal animal : locationAnimals) {
                    final Move animalMove = animal.makingMovingDecision();
                    if (animalMove != null) {
                        int newVerticalLocationIndex = i;
                        int newHorizontalLocationIndex = j;
                        final MoveDirection animalDirection = animalMove.getDirection();
                        if (animalDirection.ordinal() <= 1) {
                            // if UP or DOWN
                            newVerticalLocationIndex = newVerticalLocationIndex + ((animalDirection == MoveDirection.UP) ? -animalMove.getCountOfSteps() : animalMove.getCountOfSteps());
                        } else {
                            // if LEFT or RIGHT
                            newHorizontalLocationIndex = newVerticalLocationIndex + ((animalDirection == MoveDirection.LEFT) ? -animalMove.getCountOfSteps() : animalMove.getCountOfSteps());
                        }
                        try {
                            final Location nextAnimalLocation = locations.get(newVerticalLocationIndex, newHorizontalLocationIndex);
                            location.removeOrganism(animal);
                            nextAnimalLocation.addOrganism(animal);
                        } catch (RuntimeException ignore) {}
                    }
                }
            }
        }
    }

    protected void spawnPlants() {
        //System.out.println("Spawning plants");
        final Locations locations = island.getLocations();
        for (int i = 0; i < locations.getVerticalCount(); ++i) {
            for (int j = 0; j < locations.getHorizontalCount(i); ++j) {
                Location location = locations.get(i, j);
                spawnPlants(location);
            }
        }
    }

    protected void spawnPlants(Location location) {
        final Class[] aliveOrganismsClasses = new Class[]{Shrub.class};
        for (final Class clazz : aliveOrganismsClasses) {
            final AliveOrganismConfigurationLoader loader = Configurator.getAliveOrganismConfiguratorLoader();
            try {
                Constructor constructor = clazz.getDeclaredConstructor(AliveOrganismConfigurationLoader.class);
                AliveOrganism newOrganism = (AliveOrganism) constructor.newInstance(loader);
                AliveOrganismConfiguration newOrganismConfiguration = newOrganism.getConfiguration();
                final ThreadLocalRandom random = ThreadLocalRandom.current();
                final int newOrganismCount = random.nextInt(newOrganismConfiguration.getMaxOrganismConcentration());
                for (int i = 0; i < newOrganismCount; ++i) {
                    if (random.nextInt(101) < newOrganismConfiguration.getSpawnProbability()) {
                        location.addOrganism((AliveOrganism) constructor.newInstance(loader));
                    }
                }
                location.addOrganism(newOrganism);
            } catch (NoSuchMethodException | InvocationTargetException | InstantiationException |
                     IllegalAccessException e) {
                throw new IslandManagerSpawnAliveOrganismException(String.format("failed to spawn the AliveOrganism of %s class", clazz.getName()));
            }
        }
    }


    protected List<Callable<Void>> getAliveOrganismsProcessingTasks() {
        List<Callable<Void>> tasks = new ArrayList<>();
        for (final Location location : island.getLocations()) {
            for (final AliveOrganism animal : location.getOrganisms()) {
                if (animal instanceof Animal) {
                    for (final AliveOrganism organism : location.getOrganisms()) {
                        if (animal != organism) {
                            Callable<Void> task = () -> {
                                //System.out.printf("Animal %s trying to eat AliveOrganism %s\n", animal.getOrganismTag(), organism.getOrganismTag());
                                boolean eatingResult = ((Animal) animal).tryToEat(organism);
                                if (eatingResult) {
                                    //System.out.printf("Animal %s ate AliveOrganism %s\n", animal.getOrganismTag(), organism.getOrganismTag());
                                } else {
                                    //System.out.printf("Animal %s couldn't eat AliveOrganism %s\n", animal.getOrganismTag(), organism.getOrganismTag());
                                }
                                return null;
                            };
                            tasks.add(task);
                        }
                    }
                }
            }
        }
        return tasks;
    }

    protected void sleep() {
        try {
            TimeUnit.MILLISECONDS.sleep(configuration.getDelayBetweenCyclesMillis());
        } catch (InterruptedException e) {
            throw new IslandManagerInterruptedException("someBodyAlive cycle interrupted");
        }
    }

}
