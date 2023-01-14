package fairyShop.models.Present;

import fairyShop.common.ExceptionMessages;

public class PresentImpl implements Present {

    private String name;
    private int energyRequired;

    public PresentImpl(String name, int energyRequired) {
        setName(name);
        setEnergyRequired(energyRequired);
    }

    @Override
    public String getName() {
        return name;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(ExceptionMessages.PRESENT_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public int getEnergyRequired() {
        return energyRequired;
    }

    public void setEnergyRequired(int energyRequired) {
        if (energyRequired < 0) {
            throw new IllegalArgumentException(ExceptionMessages.PRESENT_ENERGY_LESS_THAN_ZERO);
        }
        this.energyRequired = energyRequired;
    }

    @Override
    public boolean isDone() {
        return energyRequired == 0;
    }

    @Override
    public void getCrafted() {
        setEnergyRequired(Math.max(getEnergyRequired() - 10, 0));
    }
}
