package _6_Animals;

import _6_Animals.Animal;

public class Dog extends Animal {

    private static final String SOUND = "WOOF!";

    public Dog(String name, int age, String gender) {
        super(name, age, gender);
    }

    public String produceSound() {
        return SOUND;
    }
}
