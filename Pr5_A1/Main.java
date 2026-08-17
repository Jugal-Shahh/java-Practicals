import java.util.Scanner ;
abstract class AreaShape{
    public abstract double area();
}

class Circle extends AreaShape
{
    double radius ;
    public Circle(double radius)
    {
        this.radius = radius ;
    }
    @Override
    public double area()
    {
        return Math.PI * radius * radius;
    }
}

class Rectangle extends AreaShape
{
    double length , width ;
    public Rectangle(double length , double width )
    {
        this.length = length ;
        this.width = width ;
    }
    @Override
    public double area()
    {
        return length * width ;
    }
}

class Triangle extends AreaShape
{
    double base , height ;

    public Triangle(double base , double height)
    {
        this.base = base ;
        this.height =height ;
    }
    @Override
    public double area()
    {
        return 0.5 * base * height ;
    }
}
public class Main
{
    public static void main(String args[])
    {
        int choice = -1;
        Scanner sc = new Scanner(System.in);
        while(choice !=0)
        {
        System.out.println("1. Circle");
        System.out.println("2. Rectangle");
        System.out.println("3. Triangle");
        System.out.println("0. Exit");

        System.out.print("Enter your choice: ");
        choice = sc.nextInt();

        AreaShape shape;

        if (choice == 1) {

            System.out.print("Enter radius: ");
            double radius = sc.nextDouble();

            shape = new Circle(radius);
            System.out.println("Area = " + shape.area());

        } 
        else if (choice == 2) {

            System.out.print("Enter length: ");
            double length = sc.nextDouble();

            System.out.print("Enter width: ");
            double width = sc.nextDouble();

            shape = new Rectangle(length, width);
            System.out.println("Area = " + shape.area());

        } 
        else if (choice == 3) {

            System.out.print("Enter base: ");
            double base = sc.nextDouble();

            System.out.print("Enter height: ");
            double height = sc.nextDouble();

            shape = new Triangle(base, height);
            System.out.println("Area = " + shape.area()+" \n\n");

        } 
        else if (choice == 0)
        {
            break ;
        }
        else {
            System.out.println("Invalid choice!");
        }
        }
        sc.close();
    }
}
