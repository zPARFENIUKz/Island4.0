package Island.Location.AliveOrganism.Animals.Predators;

import Config.AliveOrganismConfiguration.AliveOrganismConfigurationLoader;

public class Wolf extends Predator {

    public Wolf(AliveOrganismConfigurationLoader loader) {
        super(loader, "/Animals/Predators/Wolf");
    }

    @Override
    public Wolf reproduce() {
        return new Wolf(loader);
    }
}
