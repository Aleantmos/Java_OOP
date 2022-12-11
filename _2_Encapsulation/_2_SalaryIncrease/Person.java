package _2_SalaryIncrease;

public class Person {

    private String firstName;
    private String lastName;
    private int age;
    private double salary;

    public Person (String firstName, String lastName, int age, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.salary = salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void increaseSalary (double bonusPercent) {
        double bonusAsValue = 0;
        if (this.age >= 30) {
            bonusAsValue = this.salary * bonusPercent / 100;
        } else {
            bonusAsValue = this.salary * bonusPercent / 200;
        }
        this.setSalary(this.salary += bonusAsValue);
    }

    @Override
    public String toString() {
        String result = String.format("%s %s gets %f leva", getFirstName(), getLastName(), getSalary());
        return result;
    }
}
