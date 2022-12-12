package _3_ShoppingSpree;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    static Map<String, Person> people = new LinkedHashMap<>();
    static Map<String, Product> products = new LinkedHashMap<>();
    static boolean catchException = false;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        peopleInfo(scan);
        if (catchException) {
            return;
        }

        productsInfo(scan);
        if (catchException) {
            return;
        }

        String command;

        while (!"END".equals(command = scan.nextLine())) {
            buying(command);
        }

        printShoppingListOfPeople();

    }

    private static void printShoppingListOfPeople() {
        people.values().forEach(System.out::println);

    }

    private static void buying(String command) {
        String buyer = command.split("\\s+")[0];
        String productToBuy = command.split("\\s+")[1];

        try {
            people.get(buyer).buyProduct(products.get(productToBuy));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void productsInfo(Scanner scan) {

        String[] productsInfo = scan.nextLine().split(";");

        Arrays.stream(productsInfo).forEach(info -> {
            String productName = info.split("=")[0];
            double cost = Double.parseDouble(info.split("=")[1]);

            try {
                Product productToAdd = new Product(productName, cost);
                products.put(productName, productToAdd);
            } catch (IllegalStateException e) {
                System.out.println(e.getMessage());
                catchException = true;
            }
        });
    }

    private static void peopleInfo(Scanner scan) {

        String[] personInfo = scan.nextLine().split(";");

        Arrays.stream(personInfo).forEach(info -> {
            String personName = info.split("=")[0];
            double budget = Double.parseDouble(info.split("=")[1]);

            try {
                Person personToAdd = new Person(personName, budget);
                people.put(personName, personToAdd);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                catchException = true;
            }
        });
    }
}
