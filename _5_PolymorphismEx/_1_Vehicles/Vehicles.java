package _1_Vehicles;

public abstract class Vehicles {
    private double fuelQuantity;
    private double fuelConsumption;

    public Vehicles(double fuelQuantity, double fuelConsumption) {
        this.setFuelQuantity(fuelQuantity);
        this.setFuelConsumption(fuelConsumption);
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    public double getFuelQuantity() {
        return fuelQuantity;
    }

    public String drive(double distance) {
        String result;
        double fuelNeeded = distance * fuelConsumption;
        if (fuelNeeded <= fuelQuantity) {
            result = String.format(" travelled %.0f km", distance);
            setFuelQuantity(getFuelQuantity() - fuelNeeded);
        } else {
            result = " needs refueling";
        }
        return result;
    }

    public void refuel(double fuel) {
        setFuelQuantity(getFuelQuantity() + fuel);
    }
}
