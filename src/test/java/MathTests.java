import org.junit.jupiter.api.Test;

public class MathTests {


    @Test
    void overload() {
        int a = 2000000000;
        int b = 2000000000;
        System.out.println(a + b - b);
        System.out.println((a + b) / 2);
    }

    @Test
    void dimensions() {
        double num1 = 522.41111;
        int num2t = 6;
        double num2 = num1 + num2t;
        int num3 = (int) num2 / 2;
        System.out.println((double) num3);
    }
}
