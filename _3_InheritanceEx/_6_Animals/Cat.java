package _6_Animals;

public class Cat extends Animal{

    private static final String SOUND = "Meow meow";

    public Cat(String name, int age, String gender) {
        super(name, age, gender);
    }

    public String produceSound() {
        return SOUND;
    }

}
