package football.entities.player;

public class Women extends BasePlayer {

    private static final double KG = 60.0;
    private static final int INCREASE_PLAYER_STRENGTH_FACTOR = 115;


    public Women(String name, String nationality, int strength) {
        super(name, nationality, KG, strength);
    }

    @Override
    public void stimulation() {
        setStrength(getStrength() + INCREASE_PLAYER_STRENGTH_FACTOR);
    }
}
