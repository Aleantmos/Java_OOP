package _4_TrafficLights;

public class TrafficLight {

    private Color currentColor;

    public TrafficLight(Color currentColor) {
        this.currentColor = currentColor;
    }


    public Color changeColor() {
        switch (currentColor) {
            case RED:
                currentColor = Color.GREEN;
                break;
            case GREEN:
                currentColor = Color.YELLOW;
                break;
            case YELLOW:
                currentColor = Color.RED;
                break;
        }
        return currentColor;
    }
}
