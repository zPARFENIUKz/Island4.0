package Island.Life.Animal.Herbivore;

import Island.Configuration.AliveOrganismConfigurationLoader;
import Island.Life.AliveOrganism;

public class Rabbit extends Herbivore {
    public Rabbit(AliveOrganismConfigurationLoader loader) {
        super(loader, "/Animals/Herbivores/Rabbit");
    }

    @Override
    protected AliveOrganism reproduce() {
        return new Rabbit(loader);
    }
}
