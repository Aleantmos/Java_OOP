package _6_Animals;

public class Animal {
    private String name;
    private int age;
    private String gender;

    private static final String EXCEPTION_MESSAGE = "Invalid input!";

    public Animal(String name, int age, String gender) {
        this.setName(name);
        this.setAge(age);
        this.setGender(gender);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.trim().length() == 0 || name == null) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE);
        }
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 0 ) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE);
        }
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        if(!("Female".equals(gender) || "Male".equals(gender))) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE);
        }
        this.gender = gender;
    }


    public String produceSound () {
        return "";
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        result.append(String.format("%s", getClass().getSimpleName())).append(System.lineSeparator());
        result.append(String.format("%s %d %s", getName(), getAge(), getGender())).append(System.lineSeparator());
        result.append(String.format("%s", produceSound()));

        return result.toString();
    }
}
