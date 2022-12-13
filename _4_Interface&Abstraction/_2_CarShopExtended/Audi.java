package _2_CarShopExtended;

public class Audi extends CarImpl implements Rentable{

    private int minRentDay;
    private double pricePerDay;

    public Audi(String model, String color, int horsePower, String countryProduced, int minRentDay, double pricePerDay) {
        super(model, color, horsePower, countryProduced);
        this.minRentDay = minRentDay;
        this.pricePerDay = pricePerDay;
    }

    @Override
    public String toString() {
        String result = String.format("Minimum rental period of %d days. Price per day %f", getMinRentDay(), getPricePerDay());
        return result;
    }

    @Override
    public Integer getMinRentDay() {
        return minRentDay;
    }

    @Override
    public Double getPricePerDay() {
        return pricePerDay;
    }
}
