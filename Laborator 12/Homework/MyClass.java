import org.testng.annotations.Test;

@Test
public class MyClass {
    public static void my_method_1() {
        System.out.println("method 1");
    }

    @Test
    public static void my_method_2() {
        throw new RuntimeException("Crash");
    }

    @Test
    public int my_method_3(int x) {
        return x / 2;
    }

}
