package _1_Vehicles;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static List<Vehicles> vehicles = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        for (int curr = 0; curr < 2; curr++) {
            String[] input = scan.nextLine().split("\\s+");
            String type = input[0];
            double fuelQuantity = Double.parseDouble(input[1]);
            double fuelConsumption = Double.parseDouble(input[2]);

            if ("Car".equals(type)) {
                Vehicles car = new Car(fuelQuantity, fuelConsumption);
                vehicles.add(0, car);
            } else if ("Truck".equals(type)) {
                Vehicles truck = new Truck(fuelQuantity, fuelConsumption);
                vehicles.add(1, truck);
            }
        }

        int cnt = Integer.parseInt(scan.nextLine());

        while (cnt-- > 0) {
            String[] input = scan.nextLine().split("\\s+");
            String type = input[1];
            String command = input[0];
            String result = null;
            switch (type) {
                case "Car":
                    if (command.equals("Drive")) {
                        double distance = Double.parseDouble(input[2]);
                        result = "Car" + vehicles.get(0).drive(distance);
                    } else if (command.equals("Refuel")) {
                        double fuelToAdd = Double.parseDouble(input[2]);
                        vehicles.get(0).refuel(fuelToAdd);
                    }
                    break;
                case "Truck":
                    if (command.equals("Drive")) {
                        double distance = Double.parseDouble(input[2]);
                        result = "Truck" + vehicles.get(1).drive(distance);
                    } else if (command.equals("Refuel")) {
                        double fuelToAdd = Double.parseDouble(input[3]);
                        vehicles.get(1).refuel(fuelToAdd);
                    }
            }
            if (result != null) {
                System.out.println(result);
            }
        }
        for (Vehicles vehicle : vehicles) {
            String vehicleName = vehicle.getClass().getSimpleName();
            System.out.println(vehicleName + " " + vehicle.getFuelQuantity());
        }
    }
}
