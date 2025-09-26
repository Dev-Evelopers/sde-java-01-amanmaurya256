class Adder {
    private CalculatorTest calculator = new CalculatorTest();
    public int multiply(int a, int b) {
        boolean negative = false;
        if (a < 0 && b >= 0) {
            negative = true;
            a = -a;
        } else if (b < 0 && a >= 0) {
            negative = true;
            b = -b;
        } else if (a < 0 && b < 0) {
            a = -a;
            b = -b;
        }
        int result = 0;
        for (int i = 0; i < b; i++) {
            result = calculator.add(result, a);
        }
        return negative ? -result : result;
    }
    public int add(int a, int b) {
        return a + b;
    }
}

public class CalculatorTest {
    public int add(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {
        Adder adder = new Adder();
        System.out.println("Add: 7 + 7 = " + adder.add(7, 7));
        System.out.println("Add: 14 + 7  = " + adder.add(14, 7));
        System.out.println("Add: 7 + 7 = " + adder.add(7, 7));
    }
}
