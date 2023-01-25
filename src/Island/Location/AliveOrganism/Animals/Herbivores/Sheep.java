package Island.Location.AliveOrganism.Animals.Herbivores;

import Config.AliveOrganismConfiguration.AliveOrganismConfigurationLoader;

public class Sheep extends Herbivore {
    public Sheep(AliveOrganismConfigurationLoader loader) {
        super(loader, "/Animals/Herbivores/Sheep");
    }

    @Override
    public Sheep reproduce() {
        return new Sheep(loader);
    }
}
