package _6_Animals;

public class Tomcat extends Cat{

    private static final String GENDER = "Male";
    private static final String SOUND = "MEOW";

    public Tomcat(String name, int age, String gender) {
        super(name, age, GENDER);
    }

    public String produceSound() {
        return SOUND;
    }
}
