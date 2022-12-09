package _1_CardSuit;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        StringBuilder result = new StringBuilder();
        result.append("Card Suits:").append(System.lineSeparator());

        Arrays.stream(CardSuits.values())
                .forEach(cardSuits -> result.append(String.format("Ordinal value: %d; Name value: %s",
                        cardSuits.ordinal(), cardSuits.name())).append(System.lineSeparator()));

        System.out.println(result);
    }
}