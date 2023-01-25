package Island.Location.AliveOrganism.Animals.Herbivores;

import Config.AliveOrganismConfiguration.AliveOrganismConfigurationLoader;

public class Boar extends Herbivore {

    public Boar(AliveOrganismConfigurationLoader loader) {
        super(loader, "/Animals/Herbivores/Boar");
    }

    @Override
    public Boar reproduce() {
        return new Boar(loader);
    }
}
