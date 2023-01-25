package Config.IslandManagerConfiguration;

import Config.Configurator;
import Config.Exceptions.ConfigurationLoadingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class IslandManagerConfigurationLoader {
    protected final String configurationFilePath;

    protected final static String LOADER_TAG = "/IslandConfiguration";

    public IslandManagerConfigurationLoader(String configurationFilePath) {
        this.configurationFilePath = configurationFilePath;
    }

    public IslandManagerConfiguration load() {
        final JsonNode root = loadRootNode();
        final int verticalLocationsCount = root.at("/verticalLocationsCount").asInt();
        final int horizontalLocationsCount = root.at("/horizontalLocationsCount").asInt();
        final boolean isCycleDuringSomebodyALive = root.at("/isCycleDuringSomebodyALive").asBoolean();
        final int cycleCount = root.at("/cycleCount").asInt();
        final int delayBetweenCyclesMillis = root.at("/delayBetweenCyclesMillis").asInt();

        return new IslandManagerConfiguration(verticalLocationsCount, horizontalLocationsCount, isCycleDuringSomebodyALive, cycleCount, delayBetweenCyclesMillis);
    }

    protected JsonNode loadRootNode() {
        final ObjectMapper mapper = new ObjectMapper();
        JsonNode root;
        try {
            root = mapper.readTree(new File(configurationFilePath));
        } catch (IOException e) {
            throw new ConfigurationLoadingException("check the configuration file, failed IslandManagerConfiguration loading");
        }
        return root.at(LOADER_TAG);
    }
}
