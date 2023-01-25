package Island.Location.AliveOrganism.Animals.Herbivores;

import Config.AliveOrganismConfiguration.AliveOrganismConfigurationLoader;

public class Buffalo extends Herbivore {

    public Buffalo(AliveOrganismConfigurationLoader loader) {
        super(loader, "/Animals/Herbivores/Buffalo");
    }

    @Override
    public Buffalo reproduce() {
        return new Buffalo(loader);
    }
}
