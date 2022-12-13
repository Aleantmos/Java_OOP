package _5_BorderControl;

public class Robot extends Subject{

    private String model;

    public Robot(String model, String id) {
        super(id);
        this.model = model;
    }

    public String getModel() {
        return model;
    }
}
