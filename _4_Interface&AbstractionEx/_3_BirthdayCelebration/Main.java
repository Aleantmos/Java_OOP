package _3_BirthdayCelebration;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static List<Birthable> subjects = new ArrayList<>();
    public static String name;
    public static int age;
    public static String id;
    public static String birthDate;


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split(" ");

        while (!"End".equals(input[0])) {

            String[] tokens = input;
            String subject = tokens[0];
            switch (subject) {

                case "Citizen":
                    name = tokens[1];
                    age = Integer.parseInt(tokens[2]);
                    id = tokens[3];
                    birthDate = tokens[4];
                    Birthable citizen = new Citizen(name, age, id, birthDate);
                    subjects.add(citizen);
                    break;
                case "Pet":
                    name = tokens[1];
                    birthDate = tokens[2];
                    Birthable pet = new Pet(name, birthDate);
                    subjects.add(pet);
                    break;
            }
            input = scan.nextLine().split(" ");
        }

        String compareID = scan.nextLine();

        subjects.stream()
                .filter(subject -> subject.getBirthDate().endsWith(compareID))
                .forEach(subject -> System.out.println(subject.getBirthDate()));

    }
}
