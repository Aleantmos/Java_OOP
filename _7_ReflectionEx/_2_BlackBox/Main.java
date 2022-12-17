package _2_BlackBox;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    private final static Scanner SCANNER = new Scanner(System.in);

    private final static Map<String, Method> NAME_METHOD_MAP =
            Arrays.stream(BlackBoxInt.class.getDeclaredMethods())
                    .peek(method -> method.setAccessible(true))
                    .collect(Collectors.toMap(Method::getName, method -> method));

    private final static String END_COMMAND = "END";

    private final static String RESULT = "innerValue";

    public static void main(String[] args) throws NoSuchMethodException,
            InvocationTargetException,
            InstantiationException,
            IllegalAccessException,
            NoSuchFieldException {
        final Constructor<BlackBoxInt> BlackBoxIntConstructor =
                BlackBoxInt.class.getDeclaredConstructor(int.class);
        BlackBoxIntConstructor.setAccessible(true);

        final BlackBoxInt blackBoxInt = BlackBoxIntConstructor.newInstance(0);

        String input;

        while (!END_COMMAND.equals(input = SCANNER.nextLine())) {
            final String[] tokens = input.split("_");
            final String methodName = tokens[0];
            final Integer value = Integer.parseInt(tokens[1]);

            final Method currentMethod = NAME_METHOD_MAP.get(methodName);
            //currentMethod.setAccessible(true);
            currentMethod.invoke(blackBoxInt, value);

            Field result = blackBoxInt.getClass().getDeclaredField(RESULT);
            result.setAccessible(true);
            System.out.println(result.get(blackBoxInt));
        }

        SCANNER.close();
    }
}
