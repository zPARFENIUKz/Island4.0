package Island.Location.AliveOrganism.Animals.Predators;

import Config.AliveOrganismConfiguration.AliveOrganismConfigurationLoader;

public class Bear extends Predator {

    public Bear(AliveOrganismConfigurationLoader loader) {
        super(loader, "/Animals/Predators/Bear");
    }

    @Override
    public Bear reproduce() {
        return new Bear(loader);
    }
}
