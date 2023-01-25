package Island.Life.Animal.Predator;

import Island.Configuration.AliveOrganismConfigurationLoader;
import Island.Life.AliveOrganism;

public class Eagle extends Predator {

    public Eagle(AliveOrganismConfigurationLoader loader) {
        super(loader, "/Animals/Predators/Eagle");
    }

    @Override
    protected AliveOrganism reproduce() {
        return new Eagle(loader);
    }
}
