package football.entities.player;

public class Men extends BasePlayer {

    private static final double KG = 85.0;
    private static final int INCREASE_PLAYER_STRENGTH_FACTOR = 145;

    public Men(String name, String nationality, int strength) {
        super(name, nationality, KG, strength);
    }

    @Override
    public void stimulation() {
        setStrength(getStrength() + INCREASE_PLAYER_STRENGTH_FACTOR);
    }
}
