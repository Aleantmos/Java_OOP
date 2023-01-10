package football;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

public class FootballTeamTests {

    private FootballTeam footballTeam;
    private List<Footballer> footballerList;
    @Before
    public void setUp() {

        footballTeam = new FootballTeam("Belasica United", 5);

        Footballer footballer1 = new Footballer("Ivan");
        Footballer footballer2 = new Footballer("Pesho");
        Footballer footballer3 = new Footballer("Alex");
        Footballer footballer4 = new Footballer("Misho");
        footballTeam.addFootballer(footballer1);
        footballTeam.addFootballer(footballer2);
        footballTeam.addFootballer(footballer3);
        footballTeam.addFootballer(footballer4);

        footballerList = List.of(footballer1, footballer2, footballer3, footballer4);
    }


    @Test
    public void test_GetName() {
        String expected = "Belasica United";

        String actual = footballTeam.getName();

        Assert.assertEquals(expected, actual);
    }

    @Test(expected = NullPointerException.class)
    public void test_setNameNull() {
        FootballTeam footballTeamTests = new FootballTeam (null, 11);
    }

    @Test(expected = NullPointerException.class)
    public void test_setNameEmpty() {
        FootballTeam footballTeamTests = new FootballTeam ("", 11);
    }

    @Test
    public void test_setName() {
        FootballTeam footballTeamTests = new FootballTeam ("Bayern Botev", 11);

        String actual = footballTeamTests.getName();
        String expected = "Bayern Botev";

        Assert.assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_SetVacantPosition_Negative() {
        FootballTeam footballTeamTests = new FootballTeam ("Beroevo", -15);
    }

    @Test
    public void test_SetVacantPosition() {
        FootballTeam footballTeamTests = new FootballTeam ("Beroevo", 5);
    }

    @Test
    public void test_GetVacantPositions() {
        int expected = 5;
        int actual = footballTeam.getVacantPositions();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void test_GetCount() {
        int actual = footballTeam.getCount();
        int expected = footballerList.size();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void test_AddPlayer() {
        Footballer addFootballer = new Footballer("Marin");

        footballTeam.addFootballer(addFootballer);
        int sizeBefore = footballerList.size();
        int sizeAfter = footballTeam.getCount();

        Assert.assertEquals(sizeBefore + 1, sizeAfter);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_AddPlayer_Full() {
        Footballer addFootballer5 = new Footballer("Marin");
        Footballer addFootballer6 = new Footballer("Marin");

        footballTeam.addFootballer(addFootballer5);
        footballTeam.addFootballer(addFootballer6);
    }

    @Test
    public void test_RemovePlayer() {
        String toRemove = "Alex";
        int sizeBefore = footballTeam.getCount();
        footballTeam.removeFootballer(toRemove);
        int sizeAfter = footballTeam.getCount();

        Assert.assertEquals(sizeBefore - 1, sizeAfter);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_RemovePlayer_NotFound() {
        String toRemove = "test";
        footballTeam.removeFootballer(toRemove);
    }

    @Test
    public void test_FootballerForSale() {
        Footballer alex = footballTeam.footballerForSale("Alex");
        Assert.assertFalse(alex.isActive());
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_FootballerForSale_NotFound() {
        Footballer alex = footballTeam.footballerForSale("Vladimir");
        Assert.assertFalse(alex.isActive());
    }

    @Test
    public void test_getStatistics() {
        String names = footballerList.stream().map(Footballer::getName).collect(Collectors.joining(", "));
        String name = "Belasica United";
        String expected =  String.format("The footballer %s is in the team %s.", names, name);

        String actual = footballTeam.getStatistics();

        Assert.assertEquals(expected, actual);
    }
}
