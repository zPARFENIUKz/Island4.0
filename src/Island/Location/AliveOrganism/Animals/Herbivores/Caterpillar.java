package Island.Life.Animal.Herbivore;

import Island.Configuration.AliveOrganismConfigurationLoader;
import Island.Life.AliveOrganism;

public class Caterpillar extends Herbivore {
    public Caterpillar(AliveOrganismConfigurationLoader loader) {
        super(loader, "/Animals/Herbivores/Caterpillar");
    }

    @Override
    protected AliveOrganism reproduce() {
        return new Caterpillar(loader);
    }
}
