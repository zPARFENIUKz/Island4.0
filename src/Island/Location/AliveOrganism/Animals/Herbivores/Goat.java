package Island.Life.Animal.Herbivore;

import Island.Configuration.AliveOrganismConfigurationLoader;
import Island.Life.AliveOrganism;

public class Goat extends Herbivore {
    public Goat(AliveOrganismConfigurationLoader loader) {
        super(loader, "/Animals/Herbivores/Goat");
    }

    @Override
    protected AliveOrganism reproduce() {
        return new Goat(loader);
    }
}
