package fairyShop.models.Helper;

import fairyShop.common.ExceptionMessages;
import fairyShop.models.Instrument.Instrument;

import java.util.ArrayList;
import java.util.Collection;

public abstract class BaseHelper implements Helper {

    private String name;
    private int energy;
    private Collection<Instrument> instruments;

    public BaseHelper(String name, int energy) {
        setName(name);
        this.energy = energy;
        this.instruments = new ArrayList<>();
    }

    @Override
    public String getName() {
        return name;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(ExceptionMessages.HELPER_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public int getEnergy() {
        return energy;
    }

    private void setEnergy(int energy) {
        this.energy = energy;
    }

    @Override
    public Collection<Instrument> getInstruments() {
        return instruments;
    }

    @Override
    public void work() {
        setEnergy(Math.max(getEnergy() - 10, 0));
    }

    @Override
    public void addInstrument(Instrument instrument) {
        instruments.add(instrument);
    }

    @Override
    public boolean canWork() {
        return energy > 0;
    }
}
