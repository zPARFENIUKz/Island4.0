package Island;

import Island.Location.Location;
import Island.Location.Locations;

public class Island {
    protected final Locations locations;

    public Island(Locations locations) {
        this.locations = locations;
    }

    public Location getLocation(int vertIndex, int horIndex) {
        return locations.get(vertIndex, horIndex);
    }

    public Locations getLocations() {
        return locations;
    }
}
