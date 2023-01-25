package Island.Location.AliveOrganism.Animals.Herbivores;

import Config.AliveOrganismConfiguration.AliveOrganismConfigurationLoader;


public class Horse extends Herbivore {
    public Horse(AliveOrganismConfigurationLoader loader) {
        super(loader, "/Animals/Herbivores/Horse");
    }

    @Override
    public Horse reproduce() {
        return new Horse(super.loader);
    }
}
