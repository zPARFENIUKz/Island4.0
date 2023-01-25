package Island.Location.AliveOrganism.Animals.Herbivores;

import Config.AliveOrganismConfiguration.AliveOrganismConfigurationLoader;

public class Goat extends Herbivore {
    public Goat(AliveOrganismConfigurationLoader loader) {
        super(loader, "/Animals/Herbivores/Goat");
    }

    @Override
    public Goat reproduce() {
        return new Goat(loader);
    }
}
