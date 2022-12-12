package _4_PizzaCalories;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private String name;
    private Dough dough;
    private List<Topping> toppings;

    public Pizza(String name, int numberOfToppings) {
        this.setName(name);
        this.setToppings(numberOfToppings);
    }

    private void setName(String name) {
        if (name == null || name.trim().length() == 0 || name.length() > 15) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.INVALID_PIZZA_NAME));
        }
        this.name = name;
    }

    private void setToppings(int numberOfToppings) {
        if (numberOfToppings < 0 || numberOfToppings > 10) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_TOPPING_COUNT);
        }
        this.toppings = new ArrayList<>();
    }

    public void setDough(Dough dough) {
        this.dough = dough;
    }

    public String getName() {
        return name;
    }

    public Dough getDough() {
        return dough;
    }

    public void addTopping(Topping topping) {
        toppings.add(topping);
    }

    public double getOverallCalories() {
        double totalCalories = dough.calculateCalories() + toppings.stream().mapToDouble(topping -> topping.calculateCalories()).sum();
        return totalCalories;
    }
}
