package zoo.core;

import zoo.entities.animals.Animal;
import zoo.entities.animals.AquaticAnimal;
import zoo.entities.animals.TerrestrialAnimal;
import zoo.entities.areas.Area;
import zoo.entities.areas.LandArea;
import zoo.entities.areas.WaterArea;
import zoo.entities.foods.Food;
import zoo.entities.foods.Meat;
import zoo.entities.foods.Vegetable;
import zoo.repositories.FoodRepository;
import zoo.repositories.FoodRepositoryImpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import static zoo.common.ConstantMessages.*;
import static zoo.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {

    private FoodRepository foodRepository;
    private Collection<Area> areas;

    public ControllerImpl() {
        this.foodRepository = new FoodRepositoryImpl();
        this.areas = new ArrayList<>();
    }

    @Override
    public String addArea(String areaType, String areaName) {
        Area area;
        switch (areaType) {
            case "LandArea":
                area = new LandArea(areaName);
                break;
            case "WaterArea":
                area = new WaterArea(areaName);
                break;
            default:
                throw new NullPointerException(INVALID_AREA_TYPE);
        }
        areas.add(area);
        return String.format(SUCCESSFULLY_ADDED_AREA_TYPE, areaType);
    }

    @Override
    public String buyFood(String foodType) {
        Food food;
        switch (foodType) {
            case "Meat":
                food = new Meat();
                break;
            case "Vegetable":
                food = new Vegetable();
                break;
            default:
                throw new IllegalArgumentException(INVALID_FOOD_TYPE);
        }
        foodRepository.add(food);
        return String.format(SUCCESSFULLY_ADDED_FOOD_TYPE, foodType);
    }

    @Override
    public String foodForArea(String areaName, String foodType) {
        Food foodToAdd = foodRepository.findByType(foodType);
        Area inAreaToAdd = getArea(areaName);
        if (foodToAdd == null) {
            throw new IllegalArgumentException(String.format(NO_FOOD_FOUND, foodType));
        }
        inAreaToAdd.addFood(foodToAdd);
        foodRepository.remove(foodToAdd);
        return String.format(SUCCESSFULLY_ADDED_FOOD_IN_AREA, foodType, areaName);
    }

    @Override
    public String addAnimal(String areaName, String animalType, String animalName, String kind, double price) {
        Area area = getArea(areaName);
        Animal animal;
        switch (animalType) {
            case "AquaticAnimal":
                animal = new AquaticAnimal(animalName, kind, price);
                break;
            case "TerrestrialAnimal":
                animal = new TerrestrialAnimal(animalName, kind, price);
                break;
            default:
                throw new IllegalArgumentException(INVALID_ANIMAL_TYPE);
        }
        boolean isAquaticAndWaterArea = area.getClass().getSimpleName().equals("WaterArea") && animalType.equals("AquaticAnimal");
        boolean isTerrestrialAndLandArea = area.getClass().getSimpleName().equals("LandArea") && animalType.equals("TerrestrialAnimal");

        if ((isAquaticAndWaterArea) || (isTerrestrialAndLandArea)) {
            area.addAnimal(animal);
        } else {
            return String.format(AREA_NOT_SUITABLE);
        }
        return String.format(SUCCESSFULLY_ADDED_ANIMAL_IN_AREA, animalType, areaName);
    }

    @Override
    public String feedAnimal(String areaName) {
        Area area = getArea(areaName);
        area.feed();
        int animalsCnt = area.getAnimals().size();
        return String.format(ANIMALS_FED, animalsCnt);
    }

    @Override
    public String calculateKg(String areaName) {
        Area area = getArea(areaName);
        double totalKg = area.getAnimals()
                .stream()
                .mapToDouble(Animal::getKg)
                .sum();
        return String.format(KILOGRAMS_AREA, areaName, totalKg);
    }

    @Override
    public String getStatistics() {
        StringBuilder result = new StringBuilder();
        for (Area area : areas) {
            result.append(area.getInfo())
                    .append(System.lineSeparator());
        }
        return result.toString();
    }

    private Area getArea(String areaName) {
        return areas.stream().filter(a -> a.getName().equals(areaName)).findFirst().orElse(null);
    }
}
