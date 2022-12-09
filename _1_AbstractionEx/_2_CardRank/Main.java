package _2_CardRank;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        StringBuilder result = new StringBuilder();

        result.append("Card Ranks:").append(System.lineSeparator());

        Arrays.stream(CardRanks.values())
                .forEach(cardRanks -> result.append(String.format("Ordinal value: %d; Name value: %s",
                        cardRanks.ordinal(), cardRanks.name())).append(System.lineSeparator()));

        System.out.println(result);
    }
}
