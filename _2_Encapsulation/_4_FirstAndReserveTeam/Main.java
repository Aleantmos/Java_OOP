package _4_FirstAndReserveTeam;

import java.util.Scanner;

public class Main {
    public static String[] commands;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int peopleCnt = Integer.parseInt(scan.nextLine());

        Team team = new Team("Black Eagles");
        for (int curr = 0; curr < peopleCnt; curr++) {
            commands = scan.nextLine().split("\\s+");
            String firstName = commands[0];
            String lastName = commands[1];
            int age = Integer.parseInt(commands[2]);
            double salary = Double.parseDouble(commands[3]);

            Person player = new Person(firstName, lastName, age, salary);
            team.addPlayer(player);
        }

        System.out.println(team.toString());
    }
}
