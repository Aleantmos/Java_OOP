package fairyShop.core;

import fairyShop.common.ConstantMessages;
import fairyShop.common.ExceptionMessages;
import fairyShop.models.Helper.Happy;
import fairyShop.models.Helper.Helper;
import fairyShop.models.Helper.Sleepy;
import fairyShop.models.Instrument.Instrument;
import fairyShop.models.Instrument.InstrumentImpl;
import fairyShop.models.Present.Present;
import fairyShop.models.Present.PresentImpl;
import fairyShop.models.Shop.Shop;
import fairyShop.models.Shop.ShopImpl;
import fairyShop.repositories.HelperRepository;
import fairyShop.repositories.PresentRepository;

import java.util.List;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller {
    HelperRepository helperRepository = new HelperRepository();
    PresentRepository presentRepository = new PresentRepository();
    Shop shop = new ShopImpl();

    @Override
    public String addHelper(String type, String helperName) {
        Helper helper;
        switch (type) {
            case "Happy":
                helper = new Happy(helperName);
                break;
            case "Sleepy":
                helper = new Sleepy(helperName);
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.HELPER_DOESNT_EXIST);
        }
        helperRepository.add(helper);
        return String.format(ConstantMessages.ADDED_HELPER, type, helperName);
    }

    @Override
    public String addInstrumentToHelper(String helperName, int power) {
        if (helperRepository.findByName(helperName) == null) {
            throw new IllegalArgumentException(ExceptionMessages.HELPER_DOESNT_EXIST);
        }
        Instrument instrument = new InstrumentImpl(power);
        helperRepository.findByName(helperName).addInstrument(instrument);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_INSTRUMENT_TO_HELPER, power, helperName);
    }

    @Override
    public String addPresent(String presentName, int energyRequired) {
        Present present = new PresentImpl(presentName, energyRequired);
        presentRepository.add(present);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_PRESENT, presentName);
    }

    @Override
    public String craftPresent(String presentName) {
        int sumBrokenInstruments = 0;
        List<Helper> suitableHelpers = helperRepository.getModels().stream()
                .filter(h -> h.getEnergy() > 50)
                .collect(Collectors.toList());
        if (suitableHelpers.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessages.NO_HELPER_READY);
        }
        Present toBeCrafted = presentRepository.findByName(presentName);
        for (Helper helper : suitableHelpers) {
            shop.craft(toBeCrafted, helper);
            sumBrokenInstruments += helper.getInstruments().stream()
                    .filter(Instrument::isBroken).count();
            if (toBeCrafted.isDone()) {
                break;
            }
        }
        if (toBeCrafted.isDone()) {
            return String.format(ConstantMessages.PRESENT_DONE, presentName, "done") +
                    String.format(ConstantMessages.COUNT_BROKEN_INSTRUMENTS, sumBrokenInstruments);
        }
        return String.format(ConstantMessages.PRESENT_DONE, presentName, "not done") +
                String.format(ConstantMessages.COUNT_BROKEN_INSTRUMENTS, sumBrokenInstruments);
    }

    @Override
    public String report() {
        int craftedPresentsCnt = (int) presentRepository.getModels().stream().filter(Present::isDone).count();
        List<String> result = helperRepository.getModels().stream().map(h -> String.format(
                "Name: %s%n" +
                "Energy: %d%n" +
                "Instruments: %d not broken left%n", h.getName(), h.getEnergy(),
                h.getInstruments().stream().filter(i -> !i.isBroken()).count())).collect(Collectors.toList());
        return String.format("%d presents are done!%n", craftedPresentsCnt) + String.format("Helpers info:%n") + String.join("", result).trim();
    }
}
