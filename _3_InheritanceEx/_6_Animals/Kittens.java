package _6_Animals;

public class Kittens extends Cat{

    private static final String GENDER = "Female";
    private static final String SOUND = "Meow";

    public Kittens(String name, int age, String gender) {
        super(name, age, GENDER);
    }

    public String produceSound() {
        return SOUND;
    }
}
