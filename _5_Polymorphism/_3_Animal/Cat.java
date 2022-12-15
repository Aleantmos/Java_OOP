package _3_Animal;

public class Cat extends Animal{


    public Cat(String name, String favouriteFood) {
        super(name, favouriteFood);
    }

    @Override
    public String explainSelf() {
        String result = String.format("I am %s and my favourite food is %s MEEOW",
                getName(), getFavouriteFood());
        return result;
    }
}
