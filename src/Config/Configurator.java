package Config;

import Config.AliveOrganismConfiguration.AliveOrganismConfigurationLoader;
import Config.Exceptions.ConfigurationLoadingException;
import Config.Exceptions.ConfigurationNullPointerException;
import Island.Location.AliveOrganism.AliveOrganism;
import Island.Location.AliveOrganism.Animals.Animal;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class Configurator {
    protected static String configurationFilePath = "src/resources/properties.json";
    protected static int[][] whoEatsWhoTable;

    static {
        whoEatsWhoTable = loadWhoEatsWhoTable();
    }

    public static void reloadConfigFile(String configurationFilePath) {
        Configurator.configurationFilePath = configurationFilePath;
        whoEatsWhoTable = loadWhoEatsWhoTable();
    }


    public static boolean canEat(Animal animal, AliveOrganism organism) {
        return eatingProbability(animal, organism) > 0;
    }

    public static int eatingProbability(Animal animal, AliveOrganism organism) {
        if (animal == null || organism == null) throw new ConfigurationNullPointerException("animal and organism must be nonNull");
        final int animalVerticalIndex = animal.getConfiguration().getWhoEatsWhoVerticalIndex();
        final int organismHorizontalIndex = organism.getConfiguration().getWhoEatsWhoHorizontalIndex();
        return whoEatsWhoTable[animalVerticalIndex][organismHorizontalIndex];
    }

    public static AliveOrganismConfigurationLoader getAliveOrganismConfiguratorLoader() {
        return new AliveOrganismConfigurationLoader(configurationFilePath);
    }


    /////////////////////
    // encapsulated methods
    /////////////////////
    private static int[][] loadWhoEatsWhoTable() {
        final ObjectMapper mapper = new ObjectMapper();
        JsonNode root;
        try {
            root = mapper.readTree(new File(configurationFilePath));
            root = root.at("/WhoEatsWhoTable");
            return mapper.readValue(root.toString(), int[][].class);
        } catch (IOException e) {
            throw new ConfigurationLoadingException("whoEatsWhoTable can't be loading, check the configuration file");
        }
    }
}
