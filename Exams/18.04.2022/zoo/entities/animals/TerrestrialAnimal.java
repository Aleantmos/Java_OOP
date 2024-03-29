package zoo.entities.animals;

public class TerrestrialAnimal extends BaseAnimal{

    private static final double INITIAL_KG = 5.5;
    private static final double KG_INCREASE_FACTOR = 5.7;


    public TerrestrialAnimal(String name, String kind, double price) {
        super(name, kind, INITIAL_KG, price);
    }

    @Override
    public void eat() {
        setKg(getKg() + KG_INCREASE_FACTOR);
    }
}
