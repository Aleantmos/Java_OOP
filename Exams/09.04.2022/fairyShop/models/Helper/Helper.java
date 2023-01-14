package fairyShop.models.Helper;

import fairyShop.models.Instrument.Instrument;

import java.util.Collection;

public interface Helper {
    void work();

    void addInstrument(Instrument instrument);

    boolean canWork();

    String getName();

    int getEnergy();

    Collection<Instrument> getInstruments();
}
