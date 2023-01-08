package fairyShop.repositories;

import fairyShop.models.Present.Present;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class PresentRepository implements Repository<Present> {

    private List<Present> presents;

    public PresentRepository() {
        this.presents = new ArrayList<>();
    }

    @Override
    public Collection<Present> getModels() {
        return Collections.unmodifiableList(presents);
    }

    @Override
    public void add(Present present) {
        presents.add(present);
    }

    @Override
    public boolean remove(Present present) {
        return presents.remove(present);
    }

    @Override
    public Present findByName(String name) {
        return presents.stream().filter(p -> p.getName().equals(name)).findFirst().orElse(null);
    }
}