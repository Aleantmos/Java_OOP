package _4_PizzaCalories;

import java.util.Arrays;

public class Topping {

    private String toppingType;
    private double weight;

    public Topping(String toppingType, double weight) {
        this.setToppingType(toppingType);
        this.setWeight(weight);
    }


    private void setToppingType(String toppingType) {
        if (!IngredientsType.toppingType.containsKey(toppingType)) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.INVALID_TOPPING_TYPE, toppingType));
        }
        this.toppingType = toppingType;
    }


    private void setWeight(double weight) {
        if (weight < 1 || weight > 50) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.INVALID_TOPPING_WEIGHT, toppingType));
        }
        this.weight = weight;
    }

    public double calculateCalories() {
        double calories = 2 * weight
                * IngredientsType.toppingType.get(toppingType);
        return calories;
    }
}
