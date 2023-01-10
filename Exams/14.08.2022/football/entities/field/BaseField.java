package football.entities.field;

import football.entities.player.Player;
import football.entities.supplement.Supplement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

import static football.common.ConstantMessages.NOT_ENOUGH_CAPACITY;
import static football.common.ExceptionMessages.FIELD_NAME_NULL_OR_EMPTY;

public abstract class BaseField implements Field {

    private String name;
    private int capacity;
    private Collection<Supplement> supplements;
    private Collection<Player> players;

    public BaseField(String name, int capacity) {
        setName(name);
        this.capacity = capacity;
        supplements = new ArrayList<>();
        players = new ArrayList<>();
    }

    @Override
    public int sumEnergy() {
        return supplements.stream()
                .mapToInt(Supplement::getEnergy).sum();
    }

    @Override
    public void addPlayer(Player player) {
        if (players.size() >= capacity) {
            throw new IllegalArgumentException(NOT_ENOUGH_CAPACITY);
        }
        players.add(player);
    }

    @Override
    public void removePlayer(Player player) {
        //ToDo: check if player is in Collection
        players.remove(player);
    }

    @Override
    public void addSupplement(Supplement supplement) {
        supplements.add(supplement);
    }

    @Override
    public void drag() {
        players.forEach(Player::stimulation);
    }

    @Override
    public String getInfo() {
        StringBuilder result = new StringBuilder();
        int playersCnt = players.size();
        result.append(String.format("%s (%s)", getName(), getClass().getSimpleName()))
                .append(System.lineSeparator())
                .append(String.format("Player: %s", playersCnt == 0 ? "None" :
                        players.stream().map(Player::getName).collect(Collectors.joining(" "))))
                .append(System.lineSeparator())
                .append(String.format("Supplement: %d", supplements.size()))
                .append(System.lineSeparator())
                .append(String.format("Energy: %d", sumEnergy()));

        return result.toString();
    }

    @Override
    public Collection<Player> getPlayers() {
        return Collections.unmodifiableCollection(players);
    }

    @Override
    public Collection<Supplement> getSupplements() {
        return Collections.unmodifiableCollection(supplements);
    }

    @Override
    public String getName() {
        return name;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(FIELD_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }
}
