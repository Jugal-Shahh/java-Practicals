import java.util.Scanner;

public class Calc {

    static class DivideByZeroException extends Exception {
        public DivideByZeroException(String message) {
            super(message);
        }
    }

    static class InvalidNumberException extends Exception {
        public InvalidNumberException(String message) {
            super(message);
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter First Number: ");
            int a = sc.nextInt();
            if (a < 0) 
            {
                throw new InvalidNumberException("Negative numbers are not allowed.");
            }

            System.out.print("Enter Second Number: ");
            int b = sc.nextInt();
            if (b < 0) 
            {
                throw new InvalidNumberException("Negative numbers are not allowed.");
            }

            System.out.print("Enter the operation to perform ( + , - , * , / ): ");
            char op = sc.next().charAt(0);

            int result;
            switch (op) 
            {
                case '+':
                    result = a + b;
                    System.out.println(a + " + " + b + " = " + result);
                    break;

                case '-':
                    result = a - b;
                    System.out.println(a + " - " + b + " = " + result);
                    break;

                case '*':
                    result = a * b;
                    System.out.println(a + " * " + b + " = " + result);
                    break;

                case '/':
                    if (b == 0) {
                        throw new DivideByZeroException("Division by zero is undefined.");
                    }
                    result = a / b;
                    System.out.println(a + " / " + b + " = " + result);
                    break;

                default:
                    System.out.println("Invalid operator selected.");
                    break;
            }
        } 
        catch(DivideByZeroException e)
        {
            System.out.println("Math error : "+ e.getMessage());
        }
        catch(InvalidNumberException e)
        {
            System.out.println("Input error : "+e.getMessage());
        }
        catch(Exception e)
        {
            System.out.println("Error Invalid Input provided ");
        }
        finally
        {
            sc.close();
        }
    }
}