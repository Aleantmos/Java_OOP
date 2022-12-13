package _5_BorderControl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static List<Subject> subjects = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String command;

        while (!"End".equals(command = scan.nextLine())) {

            String[] data = command.split("\\s+");

            Subject currSubject = data.length == 2
                    ? new Robot(data[0], data[1])
                    : new Citizen(data[0], Integer.parseInt(data[1]), data[2]);
            subjects.add(currSubject);
        }
        String fakeId = scan.nextLine();

        subjects.stream()
                .filter(subject -> subject.getId().endsWith(fakeId))
                .forEach(subject -> System.out.println(subject.getId()));

    }
}
