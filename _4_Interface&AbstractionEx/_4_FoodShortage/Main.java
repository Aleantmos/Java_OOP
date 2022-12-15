package _4_FoodShortage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static List<Person> subjects = new ArrayList<>();
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int subjectsCnt = Integer.parseInt(scan.nextLine());

        for (int currPerson = 0; currPerson < subjectsCnt; currPerson++) {

            String[] inputs = scan.nextLine().split(" ");

            String name = inputs[0];
            int age = Integer.parseInt(inputs[1]);

            if (inputs.length == 4) {
                String id = inputs[2];
                String birthDate = inputs[3];
                Person citizen = new Citizen(name, age, id, birthDate);
                subjects.add(citizen);
            } else if (inputs.length == 3) {
                String group = inputs[2];
                Person rebel = new Rebel(name, age, group);
                subjects.add(rebel);
            }
        }
        String subjectName;
        int foodConsumed = 0;
        while (!"End".equals(subjectName = scan.nextLine())) {

            for (Person subject : subjects) {
                if (subject.getName().equals(subjectName)) {
                    if (subject.getClass().getSimpleName().equals("Citizen")) {
                        foodConsumed += 10;
                    } else if (subject.getClass().getSimpleName().equals("Rebel")) {
                        foodConsumed += 5;
                    }
                }
            }
        }
        System.out.println(foodConsumed);
    }
}
