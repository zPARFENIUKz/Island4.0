package Island.Location;

import Island.Location.AliveOrganism.AliveOrganism;
import Island.Location.Exceptions.LocationException.LocationNullPointerException;

import java.util.List;

public class Location {
    protected final List<AliveOrganism> organisms;

    public Location(List<AliveOrganism> organisms) {
        this.organisms = organisms;
    }

    public List<AliveOrganism> getOrganisms() {
        return organisms;
    }

    public boolean containsOrganism(AliveOrganism organism) {
        organismValidate(organism);
        return organisms.contains(organism);
    }

    public boolean addOrganism(AliveOrganism organism) {
        organismValidate(organism);
        return organisms.add(organism);
    }

    public boolean removeOrganism(AliveOrganism organism) {
        organismValidate(organism);
        return organisms.remove(organism);
    }

    protected void organismValidate(AliveOrganism organism) {
        if (organism == null) throw new LocationNullPointerException("organism cannot be null");

    }
}
