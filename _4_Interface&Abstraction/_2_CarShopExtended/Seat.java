package _2_CarShopExtended;

public class Seat extends CarImpl implements Sellable{

    private double price;

    public Seat(String model, String color, int horsePower, String countryProduced, double price) {
        super(model, color, horsePower, countryProduced);
        this.price = price;
    }

    @Override
    public Double getPrice() {
        return price;
    }


    @Override
    public String toString() {
        String result = String.format("Leon sells for %f", getPrice());
        return result;
    }
}
