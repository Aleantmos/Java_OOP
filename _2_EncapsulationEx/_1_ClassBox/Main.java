package _1_ClassBox;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int length = Integer.parseInt(scan.nextLine());
        int width = Integer.parseInt(scan.nextLine());
        int height = Integer.parseInt(scan.nextLine());

        try {
            Box box = new Box(length, width, height);
            System.out.printf("Surface Area - %.2f%n", box.calculateSurfaceArea(box));
            System.out.printf("Lateral Surface - %.2f%n", box.calculateLateralSurfaceArea(box));
            System.out.printf("Volume - %.2f%n", box.calculateVolume(box));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}