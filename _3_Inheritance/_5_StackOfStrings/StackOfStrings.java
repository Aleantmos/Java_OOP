package _5_StackOfStrings;

import java.util.ArrayList;

public class StackOfStrings {

    private ArrayList<String> data;

    public StackOfStrings() {
        this.data = new ArrayList<>();
    }

    public void push(String item) {
        this.data.add(item);
    }

    public String peek() {
        String element = data.get(data.size() - 1);
        return element;
    }

    public String pop() {
        String element = peek();
        data.remove(element);
        return element;
    }

    public boolean isEmpty() {
        boolean isEmpty = false;
        if (data.size() == 0) {
            isEmpty = true;
        }
        return isEmpty;
    }

}
