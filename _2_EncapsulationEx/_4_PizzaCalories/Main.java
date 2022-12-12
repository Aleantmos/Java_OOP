package _4_PizzaCalories;

import java.util.Scanner;

public class Main {

    static String[] input = null;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        getOrder(scan);

        try {
            String name = input[1];
            int toppingsCnt = Integer.parseInt(input[2]);
            Pizza pizza = new Pizza(name, toppingsCnt);

            getOrder(scan);
            String flourType = input[1];
            String bakingTechnique = input[2];
            double doughWeight = Double.parseDouble(input[3]);

            Dough dough = new Dough(flourType, bakingTechnique, doughWeight);
            pizza.setDough(dough);

            getOrder(scan);

            while (!"END".equals(input[0])) {
                String toppingType = input[1];
                double toppingWeight = Double.parseDouble(input[2]);
                Topping topping = new Topping(toppingType, toppingWeight);

                pizza.addTopping(topping);
                getOrder(scan);
            }

            System.out.printf("%s - %.2f", pizza.getName(), pizza.getOverallCalories());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void getOrder(Scanner scan) {
        input = scan.nextLine().split("\\s+");
    }
}
