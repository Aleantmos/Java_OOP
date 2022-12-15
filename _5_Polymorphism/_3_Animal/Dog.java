package _3_Animal;

public class Dog extends Animal{


    public Dog(String name, String favouriteFood) {
        super(name, favouriteFood);
    }

    @Override
    public String explainSelf() {
        String result = String.format("I am %s and my favourite food is %s DJAAF",
                getName(), getFavouriteFood());
        return result;
    }
}
