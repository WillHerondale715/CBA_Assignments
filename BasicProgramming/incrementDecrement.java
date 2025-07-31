public class incrementDecrement {
    public static void main(String[] args) {
        int a;

        a = 10;
        System.out.println("a++: " + (a++));
        System.out.println("After a++: " + a);

        a = 10;
        System.out.println("++a: " + (++a));
        System.out.println("After ++a: " + a);

        a = 10;
        System.out.println("a--: " + (a--));
        System.out.println("After a--: " + a);

        a = 10;
        System.out.println("--a: " + (--a));
        System.out.println("After --a: " + a);
    }
}
