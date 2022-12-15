package _1_MathOperation;

public class MathOperation {

    private int sum;
    private int result = 0;

    public MathOperation() {
        this.sum = getSum();
    }

    public int getSum() {
        return sum = getResult();
    }

    public int getResult() {
        return result;
    }

    public int add(int a, int b) {
        result = a + b;
        return result;
    }

    public int add(int a, int b, int c) {
        result = a + b + c;
        return result;
    }

    public int add(int a, int b, int c, int d) {
        result = a + b + c + d;
        return result;
    }
}
