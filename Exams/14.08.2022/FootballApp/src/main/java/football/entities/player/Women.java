package football.entities.player;

public class Women extends BasePlayer {

    private static final double INITIAL_KG = 60;
    private static final int INCREASE_STRENGTH_BY_FACTOR = 115;

    public Women(String name, String nationality, int strength) {
        super(name, nationality, INITIAL_KG, strength);
    }

    @Override
    public void stimulation() {
        setStrength(getStrength() + INCREASE_STRENGTH_BY_FACTOR);
    }
}
