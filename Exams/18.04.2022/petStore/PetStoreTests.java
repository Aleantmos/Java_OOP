package petStore;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class PetStoreTests {

    private PetStore petStore;
    private List<Animal> animals;

    @Before
    public void setUp() {
        petStore = new PetStore();
        Animal animal1 = new Animal("bird", 20, 2);
        Animal animal2 = new Animal("fly", 100, 23);
        Animal animal3 = new Animal("pig", 153, 0.5);
        Animal animal4 = new Animal("bird", 65, 53);

        animals = List.of(animal1, animal2, animal3, animal4);

        for (Animal animal : animals) {
            petStore.addAnimal(animal);
        }

    }

    @Test
    public void test_getSpecie() {
        Animal animal = new Animal("shrimp", 5, 2.5);

        String actualSpecie = animals.get(0).getSpecie();
        String expectedSpecie = "bird";
        Assert.assertEquals(actualSpecie, expectedSpecie);

        int actualKG= animal.getMaxKilograms();
        int expectedKG = 5;
        Assert.assertEquals(actualKG, expectedKG);

        double actualPrice = animal.getPrice();
        double expectedPrice = 2.5;
        Assert.assertEquals(actualPrice, expectedPrice, 1);

        animal.setAge(5);
        int age = animal.getAge();
        int expected = 5;
        Assert.assertEquals(expected, age);
    }

    @Test
    public void test_getCount() {
        int countBefore = petStore.getCount();
        Animal animal5 = new Animal("elf", 14, 5);
        petStore.addAnimal(animal5);
        int countAfter = petStore.getCount();
        Assert.assertEquals(countBefore + 1, countAfter);
    }

    @Test
    public void test_getAnimals() {
        int actualSize = petStore.getAnimals().size();
        int expectedSize = animals.size();
        Assert.assertEquals(actualSize, expectedSize);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_addAnimal_Null() {
        Animal animal = null;
        petStore.addAnimal(animal);
    }

    @Test
    public void test_addAnimal() {
        Animal animal = new Animal("eagle", 2, 4.5);
        int sizeBeforeAdd = petStore.getAnimals().size();
        petStore.addAnimal(animal);
        Assert.assertEquals(sizeBeforeAdd + 1, petStore.getAnimals().size());
    }

    @Test
    public void test_GetTheMostExpensiveAnimal() {
        Animal mostExpensiveAnimal = petStore.getTheMostExpensiveAnimal();
        double actualPrice = mostExpensiveAnimal.getPrice();
        double expectedPrice = 53;
        Assert.assertEquals(expectedPrice, actualPrice, 1);
    }

    @Test
    public void test_FindAllAnimalBySpecie() {
        List<Animal> sameSpecieList = petStore.findAllAnimalBySpecie("bird");
        int size = sameSpecieList.size();
        int expected = 2;
        Assert.assertEquals(expected, size);
    }

    @Test
    public void test_FindAllAnimalsWithMaxKilograms() {
        List<Animal> allAnimalsWithMaxKilograms = petStore.findAllAnimalsWithMaxKilograms(99);
        int size = allAnimalsWithMaxKilograms.size();
        int expected = 2;

        Assert.assertEquals(expected, size);
    }
}

