package Island.Location.AliveOrganism.Animals.Predators;

import Config.AliveOrganismConfiguration.AliveOrganismConfigurationLoader;
import Island.Location.AliveOrganism.Animals.Animal;

public abstract class Predator extends Animal {
    public Predator(AliveOrganismConfigurationLoader loader, String organismTag) {
        super(loader, organismTag);
    }
}
