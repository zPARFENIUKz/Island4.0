package Island.Life.Animal.Herbivore;

import Island.Configuration.AliveOrganismConfigurationLoader;
import Island.Life.AliveOrganism;

public class Deer extends Herbivore {
    public Deer(AliveOrganismConfigurationLoader loader) {
        super(loader, "/Animals/Herbivores/Deer");
    }

    @Override
    protected AliveOrganism reproduce() {
        return new Deer(loader);
    }
}
