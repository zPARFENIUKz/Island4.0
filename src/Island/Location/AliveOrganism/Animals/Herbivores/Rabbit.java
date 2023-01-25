package Island.Location.AliveOrganism.Animals.Herbivores;

import Config.AliveOrganismConfiguration.AliveOrganismConfigurationLoader;

public class Rabbit extends Herbivore {
    public Rabbit(AliveOrganismConfigurationLoader loader) {
        super(loader, "/Animals/Herbivores/Rabbit");
    }

    @Override
    public Rabbit reproduce() {
        return new Rabbit(loader);
    }
}
