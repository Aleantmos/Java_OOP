package fairyShop.models.Shop;

import fairyShop.models.Helper.Helper;
import fairyShop.models.Instrument.Instrument;
import fairyShop.models.Present.Present;

public class ShopImpl implements Shop {


    @Override
    public void craft(Present present, Helper helper) {

        if (helper.canWork()) {
            for (Instrument instrument : helper.getInstruments()) {
                while (!instrument.isBroken()) {
                    if (!instrument.isBroken()) {
                        present.getCrafted();
                        helper.work();
                        instrument.use();
                    }
                    if (present.isDone()) {
                        return;
                    }
                    if (!helper.canWork()) {
                        return;
                    }
                }
            }
        }
    }
}
