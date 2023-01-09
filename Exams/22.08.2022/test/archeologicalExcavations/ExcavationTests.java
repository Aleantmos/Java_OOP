package archeologicalExcavations;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class ExcavationTests {

    Excavation excavation;
    List<Archaeologist> archaeologistList;

    @Before
    public void setUp() {
        Archaeologist archaeologist1 = new Archaeologist("Peter", 100);
        Archaeologist archaeologist2 = new Archaeologist("Ivan", 100);
        Archaeologist archaeologist3 = new Archaeologist("George", 100);
        Archaeologist archaeologist4 = new Archaeologist("Hristo", 100);
        archaeologistList = List.of(archaeologist1, archaeologist2, archaeologist3, archaeologist4);

        excavation = new Excavation("Saint Peter", 4);

        for (int i = 0; i < archaeologistList.size(); i++) {
            excavation.addArchaeologist(archaeologistList.get(i));
        }
    }

    @Test
    public void test_GetCount() {
        int actual = excavation.getCount();

        int expected = archaeologistList.size();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void test_GetName() {
        String expected = "Saint Peter";

        String actual = excavation.getName();

        Assert.assertEquals(expected, actual);
    }



    @Test(expected = IllegalArgumentException.class)
    public void test_AddArchaeologist_CapacityReached() {
        Archaeologist archaeologist = new Archaeologist("Vasil", 100);

        excavation.addArchaeologist(archaeologist);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_AddArchaeologist_ArchaeologistAlreadyAdded() {

        Excavation excavation = new Excavation("Ribarica", 2);
        Archaeologist archaeologist = new Archaeologist("Vasil", 100);
        Archaeologist archaeologist1 = new Archaeologist("Vasil", 100);
        excavation.addArchaeologist(archaeologist);
        excavation.addArchaeologist(archaeologist1);
    }

    @Test
    public void test_AddArchaeologist() {
        Excavation excavation = new Excavation("Ribarica", 2);
        Archaeologist archaeologist = new Archaeologist("Vasil", 100);
        int sizeBefore = excavation.getCount();

        excavation.addArchaeologist(archaeologist);
        int sizeAfter = excavation.getCount();

        Assert.assertEquals(sizeBefore + 1, sizeAfter);
    }

    @Test
    public void test_RemoveArchaeologist_True() {
        String toRemove = "George";
        Assert.assertTrue(excavation.removeArchaeologist(toRemove));
    }

    @Test
    public void test_RemoveArchaeologist_False() {
        String toRemove = "Richard";
        Assert.assertFalse(excavation.removeArchaeologist(toRemove));
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_NegativeCapacity() {
        Excavation excavation = new Excavation("Test", -1);
    }

    @Test(expected = NullPointerException.class)
    public void test_NameIsNull() {
        Excavation excavation = new Excavation(null, 2);
    }

    @Test(expected = NullPointerException.class)
    public void test_NameIsEmpty() {
        Excavation excavation = new Excavation("", 2);
    }

    @Test
    public void test_GetEnergy(){
        Archaeologist archaeologist = new Archaeologist("Gustav", 100);
        double expected = 100;
        double actual = archaeologist.getEnergy();

        Assert.assertEquals(expected, actual, 0);
    }
}
