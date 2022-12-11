package _2_AnimalFarm;

public class Chicken {
    private String name;
    private int age;

    public Chicken(String name, int age) {
        setName(name);
        setAge(age);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    private void setName(String name) {
        if (name.trim().length() == 0) {
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        this.name = name;
    }

    private void setAge(int age) {
        if (age > 15 || age < 0) {
            throw new IllegalArgumentException("Age should be between 0 and 15.");
        }

        this.age = age;
    }

    public double productPerDay() {
        return this.calculateProductPerDay();
    }

    private double calculateProductPerDay() {
        double eggsProduced = 0;

        if (age <= 5)  {
            eggsProduced = 2;
        } else if (age <= 11) {
            eggsProduced = 1;
        } else {
            eggsProduced = 0.75;
        }
        return eggsProduced;
    }

    @Override
    public String toString() {
        String result = String.format("Chicken %s (age %d) can produce %.2f eggs per day.",
                getName(), getAge(), productPerDay());
        return result;
    }
}
