package Config.AliveOrganismConfiguration;

public class AliveOrganismConfiguration {
    final float maxOrganismWeight;
    final int maxOrganismConcentration;
    final int maxMovingSpeedLocationsPerCycle;
    final float fullStomachKg;
    final int spawnProbability;
    final int whoEatsWhoVerticalIndex;
    final int whoEatsWhoHorizontalIndex;

    public AliveOrganismConfiguration(float maxOrganismWeight, int maxOrganismConcentration, int maxMovingSpeedLocationsPerCycle, float fullStomachKg, int spawnProbability, int whoEatsWhoVerticalIndex, int whoEatsWhoHorizontalIndex) {
        this.maxOrganismWeight = maxOrganismWeight;
        this.maxOrganismConcentration = maxOrganismConcentration;
        this.maxMovingSpeedLocationsPerCycle = maxMovingSpeedLocationsPerCycle;
        this.fullStomachKg = fullStomachKg;
        this.spawnProbability = spawnProbability;
        this.whoEatsWhoVerticalIndex = whoEatsWhoVerticalIndex;
        this.whoEatsWhoHorizontalIndex = whoEatsWhoHorizontalIndex;
    }

    public float getMaxOrganismWeightKg() {
        return maxOrganismWeight;
    }

    public int getMaxOrganismConcentration() {
        return maxOrganismConcentration;
    }

    public int getMaxMovingSpeedLocationsPerCycle() {
        return maxMovingSpeedLocationsPerCycle;
    }

    public float getFullOrganismStomachKg() {
        return fullStomachKg;
    }

    public int getSpawnProbability() {
        return spawnProbability;
    }

    public int getWhoEatsWhoVerticalIndex() {
        return whoEatsWhoVerticalIndex;
    }

    public int getWhoEatsWhoHorizontalIndex() {
        return whoEatsWhoHorizontalIndex;
    }
}
