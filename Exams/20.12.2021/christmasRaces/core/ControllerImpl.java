package christmasRaces.core;

import christmasRaces.core.interfaces.Controller;
import christmasRaces.entities.cars.Car;
import christmasRaces.entities.cars.MuscleCar;
import christmasRaces.entities.cars.SportsCar;
import christmasRaces.entities.drivers.Driver;
import christmasRaces.entities.drivers.DriverImpl;
import christmasRaces.entities.races.Race;
import christmasRaces.entities.races.RaceImpl;
import christmasRaces.repositories.interfaces.CarRepository;
import christmasRaces.repositories.interfaces.DriverRepository;
import christmasRaces.repositories.interfaces.RaceRepository;
import christmasRaces.repositories.interfaces.Repository;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static christmasRaces.common.ExceptionMessages.*;
import static christmasRaces.common.OutputMessages.*;

public class ControllerImpl implements Controller {

    Repository<Car> carRepository;
    Repository<Race> raceRepository;
    Repository<Driver> driverRepository;

    public ControllerImpl(Repository<Driver> driverRepository, Repository<Car> carRepository, Repository<Race> raceRepository) {
        this.carRepository = carRepository;
        this.raceRepository = raceRepository;
        this.driverRepository = driverRepository;
    }


    @Override
    public String createDriver(String driverName) {
        Driver driverToAdd = driverRepository.getByName(driverName);
        if (driverToAdd != null) {
            throw new IllegalArgumentException(String.format(DRIVER_EXISTS, driverName));
        }
        driverToAdd = new DriverImpl(driverName);
        driverRepository.add(driverToAdd);
        return String.format(DRIVER_CREATED, driverName);
    }

    @Override
    public String createCar(String type, String model, int horsePower) {
        Car carWithModelToAdd = carRepository.getByName(model);

        if (carWithModelToAdd != null) {
            throw new IllegalArgumentException(String.format(CAR_EXISTS, model));
        }
        switch (type) {
            case "Muscle":
                carWithModelToAdd = new MuscleCar(model, horsePower);
                break;
            case "Sports":
                carWithModelToAdd = new SportsCar(model, horsePower);
                break;
        }
        carRepository.add(carWithModelToAdd);
        return String.format(CAR_CREATED, carWithModelToAdd.getClass().getSimpleName(), model);
    }

    @Override
    public String addCarToDriver(String driverName, String carModel) {
        Driver driver = driverRepository.getByName(driverName);
        if (driver == null) {
            throw new IllegalArgumentException(String.format(DRIVER_NOT_FOUND, driverName));
        }
        Car carToAddToDriver = carRepository.getByName(carModel);
        if (carToAddToDriver == null) {
            throw new IllegalArgumentException(String.format(CAR_NOT_FOUND, carModel));
        }
        driver.addCar(carToAddToDriver);
        return String.format(CAR_ADDED, driverName, carToAddToDriver.getModel());
    }

    @Override
    public String addDriverToRace(String raceName, String driverName) {
        Race inRaceToAdd = raceRepository.getByName(raceName);
        if (inRaceToAdd == null) {
            throw new IllegalArgumentException(String.format(RACE_NOT_FOUND, raceName));
        }
        Driver driverToAdd = driverRepository.getByName(driverName);
        if (driverToAdd == null) {
            throw new IllegalArgumentException(String.format(DRIVER_NOT_FOUND, driverName));
        }
        raceRepository.getByName(raceName).addDriver(driverToAdd);
        return String.format(DRIVER_ADDED, driverName, raceName);
    }

    @Override
    public String createRace(String name, int laps) {
        Race raceToCreate = raceRepository.getByName(name);
        if (raceToCreate != null) {
            throw new IllegalArgumentException(String.format(RACE_EXISTS, name));
        }
        raceToCreate = new RaceImpl(name, laps);
        raceRepository.add(raceToCreate);
        return String.format(RACE_CREATED, name);
    }

    @Override
    public String startRace(String raceName) {
        Race currentRace = raceRepository.getByName(raceName);

        if (currentRace == null) {
            throw new IllegalArgumentException(String.format(RACE_NOT_FOUND, raceName));
        }

        if (currentRace.getDrivers().size() < 3) {
            throw new IllegalArgumentException(String.format(RACE_INVALID, raceName, 3));
        }

        List<Driver> driversSorted = driverRepository.getAll()
                .stream().sorted((d1, d2) -> Double.compare(d2.getCar().calculateRacePoints(currentRace.getLaps()),
                        d1.getCar().calculateRacePoints(currentRace.getLaps())))
                .limit(3)
                .collect(Collectors.toList());

        return String.format(DRIVER_FIRST_POSITION, driversSorted.get(0).getName(), raceName) +
                System.lineSeparator() +
                String.format(DRIVER_SECOND_POSITION, driversSorted.get(1).getName(), raceName) +
                System.lineSeparator() +
                String.format(DRIVER_THIRD_POSITION, driversSorted.get(2).getName(), raceName);

    }
}
