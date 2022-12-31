package football.entities.player;

public class Men extends BasePlayer {

    private static final double INITIAL_KG = 85.5;
    private static final int INCREASE_STRENGTH_BY_FACTOR = 145;


    public Men(String name, String nationality, int strength) {
        super(name, nationality, INITIAL_KG, strength);
    }

    @Override
    public void stimulation() {
        setStrength(getStrength() + INCREASE_STRENGTH_BY_FACTOR);
    }
}
