package _4_FirstAndReserveTeam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Team {
    private String name;
    private List<Person> firstTeam;
    private List<Person> reserveTeam;

    public Team(String name) {
        this.setName(name);
        this.firstTeam = new ArrayList<>();
        this.reserveTeam = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public void addPlayer(Person personToAdd) {
        if (personToAdd.getAge() < 40) {
            firstTeam.add(personToAdd);
        } else {
            reserveTeam.add(personToAdd);
        }
    }

    public List<Person> getFirstTeam() {
        return Collections.unmodifiableList(this.firstTeam);
    }

    public List<Person> getReserveTeam() {
        return Collections.unmodifiableList(this.reserveTeam);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("First team have " + getFirstTeam().size() + " players")
                .append(System.lineSeparator());
        result.append("Second team have " + getReserveTeam().size() + " players")
                .append(System.lineSeparator());
        return result.toString();
    }
}
