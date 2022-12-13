package _6_Ferrari;

public abstract class CarImpl implements Car {

    private String driver;
    private String model;

    public CarImpl(String driver, String model) {
        this.driver = driver;
        this.model = model;
    }

    public String getDriver() {
        return driver;
    }


}
