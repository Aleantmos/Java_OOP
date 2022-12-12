package _4_PizzaCalories;

public class Dough {
    private String flourType;
    private String bakingTechnique;
    private double weight;

    public Dough(String flourType, String bakingTechnique, double weight) {
        this.setFlourType(flourType);
        this.setBakingTechnique(bakingTechnique);
        this.setWeight(weight);
    }

    private void setFlourType(String flourType) {
        if (!IngredientsType.flourType.containsKey(flourType)) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_DOUGH_TYPE);
        }
        this.flourType = flourType;
    }

    private void setBakingTechnique(String bakingTechnique) {
        if (!IngredientsType.bakingTechniques.containsKey(bakingTechnique)) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_DOUGH_TYPE);
        }
        this.bakingTechnique = bakingTechnique;
    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 200) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_DOUGH_WEIGHT);
        }
        this.weight = weight;
    }

    public double calculateCalories() {
        double calories = 2 * weight
                * IngredientsType.flourType.get(flourType)
                * IngredientsType.bakingTechniques.get(bakingTechnique);
        return calories;
    }
}
