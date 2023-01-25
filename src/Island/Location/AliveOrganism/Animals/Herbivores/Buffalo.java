package Island.Life.Animal.Herbivore;

import Island.Configuration.AliveOrganismConfigurationLoader;
import Island.Life.AliveOrganism;

public class Buffalo extends Herbivore {
    public Buffalo(AliveOrganismConfigurationLoader loader) {
        super(loader, "/Animals/Herbivores/Buffalo");
    }

    @Override
    protected AliveOrganism reproduce() {
        return new Buffalo(loader);
    }
}
