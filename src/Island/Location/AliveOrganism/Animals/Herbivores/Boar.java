package Island.Life.Animal.Herbivore;

import Island.Configuration.AliveOrganismConfigurationLoader;
import Island.Life.AliveOrganism;

public class Boar extends Herbivore {
    public Boar(AliveOrganismConfigurationLoader loader) {
        super(loader, "/Animals/Herbivores/Boar");
    }

    @Override
    protected AliveOrganism reproduce() {
        return new Boar(loader);
    }
}
