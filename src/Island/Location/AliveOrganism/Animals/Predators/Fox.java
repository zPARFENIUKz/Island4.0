package Island.Life.Animal.Predator;

import Island.Configuration.AliveOrganismConfigurationLoader;
import Island.Life.AliveOrganism;

public class Fox extends Predator {

    public Fox(AliveOrganismConfigurationLoader loader) {
        super(loader, "/Animals/Predators/Fox");
    }

    @Override
    protected AliveOrganism reproduce() {
        return new Fox(loader);
    }
}
