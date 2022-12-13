package _5_BorderControl;

public class Citizen extends Subject{

    private String name;
    private int age;

    public Citizen(String name, int age, String id) {
        super(id);
        this.age = age;
        this.name = name;
    }


}
