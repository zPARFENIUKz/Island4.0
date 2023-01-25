package Island.Life.Animal.Herbivore;

import Island.Configuration.AliveOrganismConfigurationLoader;
import Island.Life.AliveOrganism;

public class Mouse extends Herbivore {
    public Mouse(AliveOrganismConfigurationLoader loader) {
        super(loader, "/Animals/Herbivores/Mouse");
    }

    @Override
    protected AliveOrganism reproduce() {
        return new Mouse(loader);
    }
}
