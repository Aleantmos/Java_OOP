package _6_Animals;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Scanner scan = new Scanner(System.in);

        String input;

        while (!"Beast!".equals(input = scan.nextLine())) {

            String animalType = input;

            Animal animal = setAnimal(animalType, scan);

            System.out.println(animal.toString());
        }
    }

    private static Animal setAnimal(String animalType, Scanner scan) {

        String[] animalInfo = scan.nextLine().split("\\s+");
        String name = animalInfo[0];
        int age = Integer.parseInt(animalInfo[1]);
        String gender = animalInfo[2];

        switch (animalType) {
            case "Dog":
                Dog dog = new Dog(name, age, gender);
                return dog;
            case "Cat":
                Cat cat = new Cat(name, age, gender);
                return cat;
            case "Frog":
                Frog frog = new Frog(name, age, gender);
                return frog;
            case "Kittens":
                Kittens kittens = new Kittens(name, age, gender);
                return kittens;
            case "Tomcat":
                Tomcat tomcat = new Tomcat(name, age, gender);
                return tomcat;
        }
        return null;
    }
}
