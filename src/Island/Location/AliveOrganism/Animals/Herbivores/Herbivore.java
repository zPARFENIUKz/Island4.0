package Island.Location.AliveOrganism.Animals.Herbivores;

import Config.AliveOrganismConfiguration.AliveOrganismConfigurationLoader;
import Island.Location.AliveOrganism.Animals.Animal;

public abstract class Herbivore extends Animal {
    public Herbivore(AliveOrganismConfigurationLoader loader, String organismTag) {
        super(loader, organismTag);
    }
}
