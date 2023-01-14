package zoo.entities.animals;

public class AquaticAnimal extends BaseAnimal{

    private static final double INITIAL_KG = 2.5;
    private static final double KG_INCREASE_FACTOR = 7.5;

    public AquaticAnimal(String name, String kind, double price) {
        super(name, kind, INITIAL_KG, price);
    }

    @Override
    public void eat() {
        setKg(getKg() + KG_INCREASE_FACTOR);
    }
}
