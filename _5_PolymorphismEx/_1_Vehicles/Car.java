package _1_Vehicles;

public class Car extends Vehicles {

    private static final double EXTRA_FUEL_CONSUMPTION = 0.9;

    public Car(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption + EXTRA_FUEL_CONSUMPTION);
    }

}
