package Island.Location.AliveOrganism.Animals.Herbivores;

import Config.AliveOrganismConfiguration.AliveOrganismConfigurationLoader;

public class Mouse extends Herbivore {
    public Mouse(AliveOrganismConfigurationLoader loader) {
        super(loader, "/Animals/Herbivores/Mouse");
    }

    @Override
    public Mouse reproduce() {
        return new Mouse(loader);
    }
}
