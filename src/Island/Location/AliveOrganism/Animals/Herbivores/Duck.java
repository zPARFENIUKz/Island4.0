package Island.Location.AliveOrganism.Animals.Herbivores;

import Config.AliveOrganismConfiguration.AliveOrganismConfigurationLoader;

public class Duck extends Herbivore {
    public Duck(AliveOrganismConfigurationLoader loader) {
        super(loader, "/Animals/Herbivores/Duck");
    }

    @Override
    public Duck reproduce() {
        return new Duck(loader);
    }
}
