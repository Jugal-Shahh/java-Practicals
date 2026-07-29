
public class Pro3Driver {
    public static void main(String[] args) {
        Pro3Fraction f1 = new Pro3Fraction(1, 2); 
        Pro3Fraction f2 = new Pro3Fraction(2, 4); 
        Pro3Fraction f3 = new Pro3Fraction(3, 6);

        System.out.println("f1 prints: " + f1);
        System.out.println("f2 prints: " + f2);
        System.out.println("f3 prints: " + f3);

        System.out.println("f2 equals f1? " + f2.equals(f1));
        System.out.println("f3 equals f1? " + f3.equals(f1));
    }
}
