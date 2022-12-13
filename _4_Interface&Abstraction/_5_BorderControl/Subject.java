package _5_BorderControl;

public class Subject implements Identifiable{

    private String id;

    public Subject(String id) {
        this.id = id;
    }

    @Override
    public String getId() {
        return id;
    }
}
