package football.entities.player;

import football.common.ExceptionMessages;

public abstract class BasePlayer implements Player {

    private String name;
    private String nationality;
    private double kg;
    private int strength;

    public BasePlayer(String name, String nationality, double kg, int strength) {
        setName(name);
        setNationality(nationality);
        this.kg = kg;
        setStrength(strength);
    }

    private boolean isNullOrEmpty(String elementToCheck) {
        return elementToCheck == null || elementToCheck.trim().isEmpty();
    }


    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        if (isNullOrEmpty(name)) {
            throw new NullPointerException(ExceptionMessages.PLAYER_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    public String getNationality() {
        return nationality;
    }

    protected void setNationality(String nationality) {
        if (isNullOrEmpty(nationality)) {
            throw new NullPointerException(ExceptionMessages.PLAYER_NATIONALITY_NULL_OR_EMPTY);
        }
        this.nationality = nationality;
    }

    @Override
    public double getKg() {
        return kg;
    }

    @Override
    public int getStrength() {
        return strength;
    }

    protected void setStrength(int strength) {
        if (strength <= 0) {
            throw new IllegalArgumentException(ExceptionMessages.PLAYER_STRENGTH_BELOW_OR_EQUAL_ZERO);
        }
        this.strength = strength;
    }

}
