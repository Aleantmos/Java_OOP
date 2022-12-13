package _6_Ferrari;


public class Ferrari extends CarImpl {

    private static final String BRAKES = "Brakes!";
    private static final String GAS_PEDAL = "brum-brum-brum-brrrrr!";
    private static final String MODEL = "488-Spider";

    public Ferrari(String driver) {
        super(driver, MODEL);
    }

    @Override
    public String brakes() {
        return BRAKES;
    }

    @Override
    public String gas() {
        return GAS_PEDAL;
    }

    @Override
    public String toString() {
        String result = String.format("%s/%s/%s/%s",
                MODEL, brakes(), gas(), getDriver());
        return result;
    }
}
