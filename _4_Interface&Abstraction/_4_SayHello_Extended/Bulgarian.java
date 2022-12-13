package _4_SayHello_Extended;

public class Bulgarian extends BasePerson {


    public Bulgarian(String name) {
        super(name);
    }

    @Override
    public String sayHello() {
        return "Здравей";
    }
}
