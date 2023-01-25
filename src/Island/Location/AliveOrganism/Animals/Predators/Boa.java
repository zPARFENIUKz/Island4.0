package Island.Life.Animal.Predator;

import Island.Configuration.AliveOrganismConfigurationLoader;
import Island.Life.AliveOrganism;

public class Boa extends Predator {

    public Boa(AliveOrganismConfigurationLoader loader) {
        super(loader, "/Animals/Predators/Boa");
    }

    @Override
    protected AliveOrganism reproduce() {
        return new Boa(loader);
    }
}
