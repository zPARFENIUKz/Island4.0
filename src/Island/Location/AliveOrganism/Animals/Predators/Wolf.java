package Island.Life.Animal.Predator;

import Island.Configuration.AliveOrganismConfigurationLoader;
import Island.Life.AliveOrganism;

public class Wolf extends Predator {

    public Wolf(AliveOrganismConfigurationLoader loader) {
        super(loader, "/Animals/Predators/Wolf");
    }

    @Override
    protected AliveOrganism reproduce() {
        return new Wolf(loader);
    }
}
