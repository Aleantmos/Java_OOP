package _1_ClassBox;

public class Box {
    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        this.setLength(length);
        this.setWidth(width);
        this.setHeight(height);
    }

    private void setLength(double length) {
        if (length <= 0) {
            throw new IllegalArgumentException("Length cannot be zero or negative");
        }
        this.length = length;
    }

    private void setWidth(double width) {
        if (width <= 0) {
            throw new IllegalArgumentException("Width cannot be zero or negative");
        }
        this.width = width;
    }

    private void setHeight(double height) {
        if (height <= 0) {
            throw new IllegalArgumentException("Height cannot be zero or negative");
        }
        this.height = height;
    }

    public double calculateSurfaceArea(Box box) {
        double surfaceArea = 2 * box.length * box.width
                + 2 * box.length * box.height
                + 2 * box.width * box.height;
        return surfaceArea;
    }

    public double calculateLateralSurfaceArea(Box box) {
        double lateralSurfaceArea = 2 * box.length * box.height
                + 2 * box.width * box.height;
        return lateralSurfaceArea;
    }

    public double calculateVolume(Box box) {
        double volume = box.length * box.width * box.height;
        return volume;
    }
}
