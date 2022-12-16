package _1_Vehicles;

public class Truck extends Vehicles {
    private static final double EXTRA_FUEL_CONSUMPTION = 1.6;

    public Truck(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption + EXTRA_FUEL_CONSUMPTION);
    }
}
