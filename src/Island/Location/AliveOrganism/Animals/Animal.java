package Island.Location.AliveOrganism.Animals;

import Config.AliveOrganismConfiguration.AliveOrganismConfigurationLoader;
import Config.Configurator;
import Island.Location.AliveOrganism.AliveOrganism;
import Island.Location.AliveOrganism.Animals.Moving.Move;
import Island.Location.AliveOrganism.Animals.Moving.MoveDirection;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public abstract class Animal extends AliveOrganism {
    private static final int ENERGY_COST_FOR_LIVING_DIVIDER = 10;
    /////////////////////
    // inner information
    /////////////////////
    protected float nowInTheStomach;
    protected final AliveOrganismConfigurationLoader loader;
    private static final int BIRTHING_STOMACH_DIVIDER = 2;


    /////////////////////
    // Constructors
    /////////////////////
    public Animal(AliveOrganismConfigurationLoader loader, String organismTag) {
        super(loader.load(organismTag), organismTag);
        this.loader = loader;
        this.nowInTheStomach = configuration.getFullOrganismStomachKg() / BIRTHING_STOMACH_DIVIDER;
    }


    /////////////////////
    // public methods
    /////////////////////
    public boolean tryToEat(AliveOrganism organism) {
        final boolean canIEatThis = Configurator.canEat(this, organism);
        if (canIEatThis) {
            final Random random = ThreadLocalRandom.current();
            if (random.nextInt(101) <= Configurator.eatingProbability(this, organism)) {
                if (organism.die()) {
                    eatingProcessing(organism);
                    return true;
                }
            }
        }
        return false;
    }
    public Move makingMovingDecision() {
        final Random random = ThreadLocalRandom.current();
        final int countOfSteps = random.nextInt(configuration.getMaxMovingSpeedLocationsPerCycle() + 1);
        if (countOfSteps == 0) return null;
        final MoveDirection direction = MoveDirection.values()[random.nextInt(MoveDirection.values().length)];
        return new Move(direction, countOfSteps);
    }
    public boolean amIHungry() {
        return nowInTheStomach < configuration.getFullOrganismStomachKg();
    }
    public void makeMoreHungry() {
        nowInTheStomach -= configuration.getFullOrganismStomachKg() / ENERGY_COST_FOR_LIVING_DIVIDER;
        if (nowInTheStomach < 0) {
            die();
        }
    }


    /////////////////////
    // abstract methods
    /////////////////////
    public abstract Animal reproduce();

    /////////////////////
    // encapsulated methods
    /////////////////////
    protected void eatingProcessing(AliveOrganism organism) {
         final float nextInStomach = nowInTheStomach + organism.getCurrentWeight();
         nowInTheStomach = Math.min(nextInStomach, configuration.getFullOrganismStomachKg());
    }
}
