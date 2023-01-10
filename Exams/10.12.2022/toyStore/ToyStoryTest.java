package toyStore;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class ToyStoryTest {
    private ToyStore toyStore;

    @Before
    public void setUp() {
        toyStore = new ToyStore();
    }

    @Test
    public void test_GetVaultCells() {
        Map<String, Toy> toyShelf = new LinkedHashMap<>();

        toyShelf.put("A", null);
        toyShelf.put("B", null);
        toyShelf.put("C", null);
        toyShelf.put("D", null);
        toyShelf.put("E", null);
        toyShelf.put("F", null);
        toyShelf.put("G", null);
        Assert.assertEquals(toyShelf, toyStore.getToyShelf());
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_AddToyNoShelf() throws OperationNotSupportedException {
        Toy toy1 = new Toy("Disney", "A1");
        toyStore.addToy("H", toy1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_AddToyShelfFull() throws OperationNotSupportedException {
        Toy toy1 = new Toy("Disney", "A1");
        Toy toy2 = new Toy("Disney", "A2");

        toyStore.addToy("A", toy1);
        toyStore.addToy("A", toy2);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void test_AddToy_ToyAlreadyOnShelf() throws OperationNotSupportedException {
        Toy toy1 = new Toy("Disney", "A1");
        toyStore.addToy("A", toy1);
        toyStore.addToy("B", toy1);
    }

    @Test
    public void test_AddToy() throws OperationNotSupportedException {
        Toy toy1 = new Toy("Disney", "A1");
        Toy toy2 = new Toy("Disney", "A2");
        toyStore.addToy("A", toy1);
        toyStore.addToy("B", toy2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_RemoveToy_NoShelf() throws OperationNotSupportedException {
        Toy toy1 = new Toy("Disney", "A1");
        toyStore.addToy("A", toy1);

        toyStore.removeToy("Z", toy1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_RemoveToy_NoToy() throws OperationNotSupportedException {
        Toy toy1 = new Toy("Disney", "A1");
        Toy toy2 = new Toy("Disney", "A2");
        toyStore.addToy("A", toy1);
        toyStore.removeToy("A", toy2);

    }

    @Test
    public void test_RemoveToy() throws OperationNotSupportedException {
        Toy toy1 = new Toy("Disney", "A1");
        toyStore.addToy("A", toy1);
        toyStore.removeToy("A", toy1);
    }

}