package christmasRaces.repositories.interfaces;

import christmasRaces.entities.drivers.Driver;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class DriverRepository implements Repository<Driver>{

    Collection<Driver> drivers;

    public DriverRepository() {
        this.drivers = new ArrayList<>();
    }

    @Override
    public Driver getByName(String name) {
        return drivers.stream()
                .filter(d -> d.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Collection<Driver> getAll() {
        return Collections.unmodifiableCollection(drivers);
    }

    @Override
    public void add(Driver driver) {
        drivers.add(driver);
    }

    @Override
    public boolean remove(Driver driver) {
        return drivers.remove(driver);
    }
}
