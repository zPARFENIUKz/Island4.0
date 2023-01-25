package Island.Location;

import Island.Location.Exceptions.LocationsException.LocationsIllegalArgumentException;
import Island.Location.Exceptions.LocationsException.LocationsIndexOutOfBoundsException;

import java.util.Iterator;

public class Locations implements Iterable<Location> {
    protected final Location[][] locations;

    public Locations(Location[][] locations) {
        this.locations = locations;
    }

    public Location get(int vertIndex, int horIndex) {
        if (vertIndex < 0 || horIndex < 0) throw new LocationsIllegalArgumentException("negative index was passed");
        if (vertIndex >= locations.length || horIndex >= locations[vertIndex].length) throw new LocationsIndexOutOfBoundsException("index out of bounds");
        return locations[vertIndex][horIndex];
    }

    public int getVerticalCount() {
        return locations.length;
    }

    public int getHorizontalCount(int verticalIndex) {
        return locations[verticalIndex].length;
    }


    public Iterator<Location> iterator() {
        return new Iterator<Location>() {
            int verticalIndex = 0;
            int horizontalIndex = 0;
            @Override
            public boolean hasNext() {
                try {
                    return verticalIndex < getVerticalCount() || horizontalIndex < getHorizontalCount(verticalIndex);
                } catch (Exception e) {
                    return false;
                }
            }

            @Override
            public Location next() {
                if (horizontalIndex < getHorizontalCount(verticalIndex)) {
                    return locations[verticalIndex][horizontalIndex++];
                } else if (verticalIndex < getVerticalCount()){
                    horizontalIndex = 0;
                    return locations[verticalIndex++][horizontalIndex];
                }
                return null;
            }
        };
    }
}
