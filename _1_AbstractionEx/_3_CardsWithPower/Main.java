package _3_CardsWithPower;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        RankPower rankPower = RankPower.valueOf(scan.nextLine());
        SuitPower suitPower = SuitPower.valueOf(scan.nextLine());

        PowerCalculator powerCalculator = new PowerCalculator(rankPower, suitPower);

        int power = powerCalculator.getPower();
        System.out.printf("Card name: %s of %s; Card power: %d",
                rankPower.name(), suitPower.name(), power);
    }
}
