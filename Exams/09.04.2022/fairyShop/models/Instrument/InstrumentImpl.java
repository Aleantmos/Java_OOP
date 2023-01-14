package fairyShop.models.Instrument;

public class InstrumentImpl implements Instrument {

    private int power;

    public InstrumentImpl(int power) {
        this.power = power;
    }

    @Override
    public int getPower() {
        return power;
    }

    private void setPower(int power) {
        this.power = power;
    }

    @Override
    public void use() {
        setPower(Math.max(getPower() - 10, 0));
    }

    @Override
    public boolean isBroken() {
        return power == 0;
    }
}
