package Island.Life.Animal.Herbivore;

import Island.Configuration.AliveOrganismConfigurationLoader;
import Island.Life.AliveOrganism;

public class Duck extends Herbivore {
    public Duck(AliveOrganismConfigurationLoader loader) {
        super(loader, "/Animals/Herbivores/Duck");
    }

    @Override
    protected AliveOrganism reproduce() {
        return new Duck(loader);
    }
}
