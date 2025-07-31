public class arithmetic {
    public static void main(String[] args) {
        double num1 = 25.5;
        double num2 = 7.3;

        System.out.println("Addition: " + (num1 + num2));
        System.out.println("Subtraction: " + (num1 - num2));
        System.out.println("Multiplication: " + (num1 * num2));
        System.out.println("Division: " + (num1 / num2));

        // Modulus using int cast
        int a = (int) num1;
        int b = (int) num2;
        System.out.println("Modulus: " + (a % b));
    }
}
