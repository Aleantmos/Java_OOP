package christmasRaces.entities.cars;

import christmasRaces.common.ExceptionMessages;

public class SportCar extends BaseCar {

    private static final double CUBIC_CENTIMETERS = 3000;
    public SportCar(String model, int horsePower) {
        super(model, horsePower, CUBIC_CENTIMETERS);
    }

    private void checkHorsePower(int horsePower) {
        if (horsePower < 250 || horsePower > 450) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.INVALID_HORSE_POWER, horsePower));
        }
    }
}
