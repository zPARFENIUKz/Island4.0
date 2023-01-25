package Island.Life.Animal.Herbivore;

import Island.Configuration.AliveOrganismConfigurationLoader;
import Island.Life.AliveOrganism;

public class Sheep extends Herbivore {
    public Sheep(AliveOrganismConfigurationLoader loader) {
        super(loader, "/Animals/Herbivores/Sheep");
    }

    @Override
    protected AliveOrganism reproduce() {
        return new Sheep(loader);
    }
}
