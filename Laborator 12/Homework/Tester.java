import com.github.javafaker.Faker;
import org.testng.annotations.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.util.Random;

public class Tester {

    public void test(String className) throws ClassNotFoundException {

        Class<?> cls = Class.forName(className);

        if (!cls.isAnnotationPresent(Test.class) || !Modifier.isPublic(cls.getModifiers())) {
            return;
        }
        System.out.println("Class " + cls.getSimpleName() + " tested");
        int testSuccess = 0, testTotal = 0;

        for (Method method : cls.getMethods()) {
            if (!method.isAnnotationPresent(Test.class)) {
                continue;
            }

            Object[] args = new Object[method.getParameters().length];
            Random random = new Random();
            Faker faker = new Faker();

            int index = 0;
            for (Parameter param : method.getParameters()) {
                if (param.getType() == int.class) {
                    int currParam = random.nextInt(Integer.MIN_VALUE, Integer.MAX_VALUE);
                    args[index] = currParam;
                }
                else if (param.getType() == String.class) {
                    String currParam = faker.name().name();
                    args[index] = currParam;
                }
                index++;
            }

            Object obj = null;
            method.setAccessible(true);
            try {
                obj = cls.newInstance();
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }

            if (obj == null) {
                continue;
            }

            try {
                Object retObj = method.invoke(obj, args);
                testSuccess++;
                if (retObj != null) {
                    System.out.println("Method " + method.getName() + " returned: " + retObj);
                }
            } catch (InvocationTargetException e) {

            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } finally {
                testTotal++;
            }
        }
        System.out.println("Tests passed: " + testSuccess + "/" + testTotal + "\n");
    }
}
