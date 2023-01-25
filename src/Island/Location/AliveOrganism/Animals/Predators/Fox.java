package Island.Location.AliveOrganism.Animals.Predators;

import Config.AliveOrganismConfiguration.AliveOrganismConfigurationLoader;

public class Fox extends Predator {

    public Fox(AliveOrganismConfigurationLoader loader) {
        super(loader, "/Animals/Predators/Fox");
    }

    @Override
    public Fox reproduce() {
        return new Fox(loader);
    }
}
