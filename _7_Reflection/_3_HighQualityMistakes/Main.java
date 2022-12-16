package _3_HighQualityMistakes;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Class reflectionClass = Reflection.class;

        Field[] declaredFields = reflectionClass.getDeclaredFields();

        for (Field declaredField : declaredFields) {
            List<Field> fields = new ArrayList<>();
            if (!Modifier.isPrivate(declaredField.getModifiers())) {
                fields.add(declaredField);
            }
            fields.stream()
                    .sorted(Comparator.comparing(Field::getName))
                    .forEach(s -> System.out.printf("%s must be private!%n", s.getName()));
        }

        Method[] declaredMethods = reflectionClass.getDeclaredMethods();

        for (Method declaredMethod : declaredMethods) {
            List<Method> getters = new ArrayList<>();
            if (declaredMethod.getName().startsWith("get") && !Modifier.isPublic(declaredMethod.getModifiers())) {
                getters.add(declaredMethod);
            }
            getters.stream()
                    .sorted(Comparator.comparing(Method::getName))
                    .forEach(s -> System.out.printf("%s must be public!%n", s.getName()));
        }

        for (Method declaredMethod : declaredMethods) {
            List<Method> setters = new ArrayList<>();
            if (declaredMethod.getName().startsWith("set") && !Modifier.isPrivate(declaredMethod.getModifiers())) {
                setters.add(declaredMethod);
            }
            setters.stream()
                    .sorted(Comparator.comparing(Method::getName))
                    .forEach(s -> System.out.printf("%s must be private!%n", s.getName()));
        }
    }
}
