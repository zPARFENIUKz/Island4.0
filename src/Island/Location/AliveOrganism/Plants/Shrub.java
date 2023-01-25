package Island.Location.AliveOrganism.Plants;

import Config.AliveOrganismConfiguration.AliveOrganismConfiguration;
import Config.AliveOrganismConfiguration.AliveOrganismConfigurationLoader;

public class Shrub extends Plant {
    private static final String organismTag = "/Plants/Shrubs/Shrub";

    public Shrub(AliveOrganismConfigurationLoader loader) {
        super(loader.load(organismTag), organismTag);
    }
}
