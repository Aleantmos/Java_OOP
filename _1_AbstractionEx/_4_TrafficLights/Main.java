package _4_TrafficLights;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        List<String> colors = Arrays.stream(scan.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        List<TrafficLight> trafficLights = new ArrayList<>();
        for (String color : colors) {

            Color currColor = Color.valueOf(color);
            TrafficLight currTrafficLight = new TrafficLight(currColor);
            trafficLights.add(currTrafficLight);
        }

        int n = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < n; i++) {

            trafficLights.stream()
                    .forEach(trafficLight -> System.out.print(
                            String.format("%s ",
                                    trafficLight.changeColor().toString())));
            System.out.println();
        }
    }
}
