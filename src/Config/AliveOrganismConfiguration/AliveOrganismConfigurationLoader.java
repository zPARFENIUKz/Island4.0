package Config.AliveOrganismConfiguration;

import Config.Exceptions.ConfigurationLoadingException;
import Config.Exceptions.ConfigurationNullPointerException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class AliveOrganismConfigurationLoader {
    protected final String configurationFilePath;
    protected static final String LOADER_TAG = "/AliveOrganisms";
    protected static final Map<String, AliveOrganismConfiguration> cash = new HashMap<>();

    public AliveOrganismConfigurationLoader(String configurationFilePath) {
        this.configurationFilePath = configurationFilePath;
    }

    public AliveOrganismConfiguration load(String organismTag) {
        tagValidate(organismTag);
        final String key = configurationFilePath + LOADER_TAG + organismTag;
        if (cash.containsKey(key)) {
            return cash.get(key);
        }
        final JsonNode root = loadRootNode(organismTag);
        final float maxOrganismWeight = (float) root.at("/maxOrganismWeight").asDouble();
        final int maxOrganismConcentration = root.at("/maxOrganismConcentration").asInt();
        final int maxMovingSpeedLocationsPerCycle = root.at("/maxMovingSpeedLocationsPerCycle").asInt();
        final float fullStomachKg = (float) root.at("/fullStomachKg").asDouble();
        final int spawnProbability = root.at("/spawnProbability").asInt();
        final int whoEatsWhoVerticalIndex = root.at("/whoEatsWhoVerticalIndex").asInt();
        final int whoEatsWhoHorizontalIndex = root.at("/whoEatsWhoHorizontalIndex").asInt();
        AliveOrganismConfiguration configuration = new AliveOrganismConfiguration(
                maxOrganismWeight,
                maxOrganismConcentration,
                maxMovingSpeedLocationsPerCycle,
                fullStomachKg,
                spawnProbability,
                whoEatsWhoVerticalIndex,
                whoEatsWhoHorizontalIndex);
        cash.put(key, configuration);
        return configuration;
    }

    private void tagValidate(String tag) {
        if (tag == null) throw new ConfigurationNullPointerException("tag must be nonNull");
    }

    private JsonNode loadRootNode(String organismTag) {
        final ObjectMapper mapper = new ObjectMapper();
        JsonNode root;
        try {
            root = mapper.readTree(new File(configurationFilePath));
        } catch (IOException e) {
            throw new ConfigurationLoadingException("check the configuration file, it can't be load correctly");
        }
        return root.at(LOADER_TAG + organismTag);
    }
}
