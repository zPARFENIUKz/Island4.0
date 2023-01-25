package Island.Location.AliveOrganism.Animals.Predators;

import Config.AliveOrganismConfiguration.AliveOrganismConfigurationLoader;

public class Eagle extends Predator {

    public Eagle(AliveOrganismConfigurationLoader loader) {
        super(loader, "/Animals/Predators/Eagle");
    }

    @Override
    public Eagle reproduce() {
        return new Eagle(loader);
    }
}
