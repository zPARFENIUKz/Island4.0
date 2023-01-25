package Island.Location.AliveOrganism;

import Config.AliveOrganismConfiguration.AliveOrganismConfiguration;
import Island.Location.AliveOrganism.Exceptions.AliveOrganismNullPointerException;

import java.util.concurrent.atomic.AtomicBoolean;

public abstract class AliveOrganism {
    /////////////////////
    // inner information
    /////////////////////
    protected final AliveOrganismConfiguration configuration;
    protected float currentWeight;
    protected final AtomicBoolean isAlive = new AtomicBoolean(true);
    protected final String organismTag;

    private static final int BIRTHING_WEIGHT_DIVIDER = 2;
    private static final int GROWING_UP_WEIGHT_DIVIDER = 20;


    /////////////////////
    // Constructors
    /////////////////////
    public AliveOrganism(AliveOrganismConfiguration configuration, String organismTag) {
        this.organismTag = organismTag;
        configurationValidate(configuration);
        this.configuration = configuration;
        this.currentWeight = configuration.getMaxOrganismWeightKg() / BIRTHING_WEIGHT_DIVIDER;
    }

    /////////////////////
    // getters
    /////////////////////
    public AliveOrganismConfiguration getConfiguration() {
        return configuration;
    }
    public float getCurrentWeight() {
        return currentWeight;
    }

    public String getOrganismTag() {
        return organismTag;
    }

    /////////////////////
    // public methods
    /////////////////////
    public boolean isAlive() {
        return isAlive.get();
    }
    public boolean die() {
        return isAlive.compareAndSet(true, false);
    }
    public void growUp() {
        if (currentWeight == configuration.getMaxOrganismWeightKg()) return;
        final float nextWeight = currentWeight + configuration.getMaxOrganismWeightKg() / GROWING_UP_WEIGHT_DIVIDER;
        currentWeight = Math.min(nextWeight, configuration.getMaxOrganismWeightKg());
    }
    public boolean isAdult() {
        return currentWeight == configuration.getMaxOrganismWeightKg();
    }


    /////////////////////
    // encapsulated methods
    /////////////////////
    private void configurationValidate(AliveOrganismConfiguration configuration) {
        if (configuration == null) throw new AliveOrganismNullPointerException("configuration, using for AliveOrganism creating, must be nonNull");
    }
}
