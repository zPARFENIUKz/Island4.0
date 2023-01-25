package Island.Location.AliveOrganism.Animals.Predators;

import Config.AliveOrganismConfiguration.AliveOrganismConfigurationLoader;

public class Boa extends Predator {

    public Boa(AliveOrganismConfigurationLoader loader) {
        super(loader, "/Animals/Predators/Boa");
    }

    @Override
    public Boa reproduce() {
        return new Boa(loader);
    }
}
