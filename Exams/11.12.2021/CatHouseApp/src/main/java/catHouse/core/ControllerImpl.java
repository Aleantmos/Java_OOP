package catHouse.core;

import catHouse.entities.cat.Cat;
import catHouse.entities.cat.LonghairCat;
import catHouse.entities.cat.ShorthairCat;
import catHouse.entities.houses.House;
import catHouse.entities.houses.LongHouse;
import catHouse.entities.houses.ShortHouse;
import catHouse.entities.toys.Ball;
import catHouse.entities.toys.BaseToy;
import catHouse.entities.toys.Mouse;
import catHouse.entities.toys.Toy;
import catHouse.repositories.ToyRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import static catHouse.common.ConstantMessages.*;
import static catHouse.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {

    private ToyRepository toys = new ToyRepository();
    private Collection<House> houses = new ArrayList<>();

    @Override
    public String addHouse(String type, String name) {
        House house;
        switch (type) {
            case "LongHouse":
                house = new LongHouse(name);
                break;
            case "ShortHouse":
                house = new ShortHouse(name);
                break;
            default:
                throw new NullPointerException(INVALID_HOUSE_TYPE);
        }
        houses.add(house);
        return String.format(SUCCESSFULLY_ADDED_HOUSE_TYPE, type);
    }

    @Override
    public String buyToy(String type) {
        Toy toy;
        switch (type) {
            case "Mouse":
                toy = new Mouse();
                break;
            case "Ball":
                toy = new Ball();
                break;
            default:
                throw new IllegalArgumentException(INVALID_TOY_TYPE);
        }
        toys.buyToy(toy);
        return String.format(SUCCESSFULLY_ADDED_TOY_TYPE, type);
    }

    @Override
    public String toyForHouse(String houseName, String toyType) {
        Toy toy = toys.findFirst(toyType);
        if (toy == null) {
            throw new IllegalArgumentException(String.format(NO_TOY_FOUND, toyType));
        }
        toys.removeToy(toy);
        House house = getHouse(houseName);
        house.buyToy(toy);
        return String.format(SUCCESSFULLY_ADDED_TOY_IN_HOUSE, toyType, houseName);
    }

    @Override
    public String addCat(String houseName, String catType, String catName, String catBreed, double price) {
        Cat cat;
        switch (catType) {
            case "LonghairCat":
                cat = new LonghairCat(catName, catBreed, price);
                break;
            case "ShorthairCat":
                cat = new ShorthairCat(catName, catBreed, price);
                break;
            default:
                throw new IllegalArgumentException(INVALID_CAT_TYPE);
        }
        House house = getHouse(houseName);
        boolean longCatAndHouse = cat.getClass().getSimpleName().equals("LonghairCat") && house.getClass().getSimpleName().equals("LongHouse");
        boolean shortCatAndHouse = cat.getClass().getSimpleName().equals("ShorthairCat") && house.getClass().getSimpleName().equals("ShortHouse");
        if (!longCatAndHouse && !shortCatAndHouse) {
            return UNSUITABLE_HOUSE;
        }
        house.addCat(cat);
        return String.format(SUCCESSFULLY_ADDED_CAT_IN_HOUSE, catType, houseName);
    }

    private House getHouse(String houseName) {
        return houses.stream().filter(h -> h.getName().equals(houseName)).findFirst().orElse(null);
    }

    @Override
    public String feedingCat(String houseName) {
        House house = getHouse(houseName);
        house.feeding();
        int fedCats = house.getCats().size();
        return String.format(FEEDING_CAT, fedCats);
    }

    @Override
    public String sumOfAll(String houseName) {
        House house = getHouse(houseName);
        double totalPrice = house.getCats().stream().mapToDouble(c -> c.getPrice()).sum()
                + house.getToys().stream().mapToDouble(t -> t.getPrice()).sum();
        return String.format(VALUE_HOUSE, houseName, totalPrice);
    }

    @Override
    public String getStatistics() {
        return houses.stream().map(House::getStatistics).collect(Collectors.joining(System.lineSeparator()));
    }
}
