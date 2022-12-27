package zoo.entities.animals;

import static zoo.common.ExceptionMessages.*;

public abstract class BaseAnimal implements Animal {
    private String name;

    private String kind;
    private double kg;
    private double price;

    protected BaseAnimal(String name, String kind, double kg, double price) {
        setName(name);
        setKind(kind);
        this.kg = kg;
        setPrice(price);
    }

    private void setName(String name) {
        checkNullOrEmpty(name, ANIMAL_NAME_NULL_OR_EMPTY);
        this.name = name;
    }

    private void setKind(String kind) {
        checkNullOrEmpty(kind, ANIMAL_KIND_NULL_OR_EMPTY);
        this.kind = kind;
    }

    private void setPrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException(ANIMAL_PRICE_BELOW_OR_EQUAL_ZERO);
        }
        this.price = price;
    }

    protected void setKg(double kg) {
        this.kg = kg;
    }

    private void checkNullOrEmpty(String str, String exception) {
        if (str == null || str.trim().isEmpty()) {
            throw new NullPointerException(exception);
        }
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getKg() {
        return kg;
    }

    @Override
    public double getPrice() {
        return price;
    }
}
