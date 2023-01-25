package Island.Location.AliveOrganism.Animals.Herbivores;

import Config.AliveOrganismConfiguration.AliveOrganismConfigurationLoader;

public class Deer extends Herbivore {
    public Deer(AliveOrganismConfigurationLoader loader) {
        super(loader, "/Animals/Herbivores/Deer");
    }

    @Override
    public Deer reproduce() {
        return new Deer(loader);
    }
}
