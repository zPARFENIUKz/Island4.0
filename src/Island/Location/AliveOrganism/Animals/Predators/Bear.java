package Island.Life.Animal.Predator;

import Island.Configuration.AliveOrganismConfigurationLoader;
import Island.Life.AliveOrganism;

public class Bear extends Predator {

    public Bear(AliveOrganismConfigurationLoader loader) {
        super(loader, "/Animals/Predators/Bear");
    }

    @Override
    protected AliveOrganism reproduce() {
        return new Bear(loader);
    }
}
