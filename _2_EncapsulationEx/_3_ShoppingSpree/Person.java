package _3_ShoppingSpree;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Person {
    private String name;
    private double money;
    private List<Product> products;

    public Person(String name, double money) {
        this.setName(name);
        this.setMoney(money);
        products = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        if (name.trim().length() == 0) {
            throw new IllegalArgumentException("Name cannot be empty");
        } else {
            this.name = name;
        }
    }

    public double getMoney() {
        return money;
    }

    private void setMoney(double money) {
        if (money < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        } else {
            this.money = money;
        }
    }

    public void buyProduct(Product product) {
        double budget = getMoney();

        if (product.getCost() <= budget) {
            this.products.add(product);
            budget -= product.getCost();
            setMoney(budget);
            System.out.printf("%s bought %s%n", getName(), product.getName());
        } else {
            throw new IllegalArgumentException(getName() + " can't afford " + product.getName());
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        if (products.isEmpty()) {
            result.append(String.format("%s - Nothing bought", getName()));
            return result.toString();
        }
        result.append(String.format("%s - ", getName())).append(products.stream().map(Product::getName).collect(Collectors.joining(", ")));
        return result.toString();
    }
}
