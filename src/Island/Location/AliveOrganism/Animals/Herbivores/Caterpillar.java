package Island.Location.AliveOrganism.Animals.Herbivores;

import Config.AliveOrganismConfiguration.AliveOrganismConfigurationLoader;

public class Caterpillar extends Herbivore {
    public Caterpillar(AliveOrganismConfigurationLoader loader) {
        super(loader, "/Animals/Herbivores/Caterpillar");
    }

    @Override
    public Caterpillar reproduce() {
        return new Caterpillar(loader);
    }
}
