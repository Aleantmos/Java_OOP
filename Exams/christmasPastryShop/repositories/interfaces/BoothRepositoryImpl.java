package christmasPastryShop.repositories.interfaces;

import christmasPastryShop.entities.booths.interfaces.Booth;
import christmasPastryShop.entities.delicacies.interfaces.Delicacy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class BoothRepositoryImpl implements BoothRepository<Booth>{
    private Collection<Booth> booths;

    public BoothRepositoryImpl() {
        this.booths = new ArrayList<>();
    }

    @Override
    public Booth getByNumber(int number) {
        Booth booth = booths.stream().filter(b -> b.getBoothNumber() == number).findFirst().orElse(null);
        return booth;
    }

    @Override
    public Collection getAll() {
        return Collections.unmodifiableCollection(this.booths);
    }

    @Override
    public void add(Booth booth) {
        this.booths.add(booth);
    }
}
