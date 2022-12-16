package _2_GettersAndSetters;

import java.lang.reflect.Method;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Class reflectionClass = Reflection.class;

        Method[] declaredMethods = reflectionClass.getDeclaredMethods();

        List<Method> getters = new ArrayList<>();
        List<Method> setters = new ArrayList<>();

        for (Method declaredMethod : declaredMethods) {
            if (declaredMethod.getName().startsWith("get")) {
                getters.add(declaredMethod);
            } else if (declaredMethod.getName().startsWith("set")) {
                setters.add(declaredMethod);
            }
        }

        getters.stream()
                .sorted(Comparator.comparing(Method::getName))
                .forEach(s -> System.out.printf("%s will return class %s%n", s.getName(), s.getReturnType().getName()));

        setters.stream()
                .sorted(Comparator.comparing(Method::getName))
                .forEach(s -> System.out.printf("%s will return class %s%n", s.getName(), s.getReturnType().getName()));
    }
}
