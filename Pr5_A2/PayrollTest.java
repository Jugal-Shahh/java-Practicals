import java.util.Scanner;

abstract class Employee {
    private String name;
    private int id;

    public Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public abstract double monthlySalary();
}

class FullTime extends Employee {
    private double salary;

    public FullTime(String name, int id, double salary) {
        super(name, id);
        this.salary = salary;
    }

    public double monthlySalary() {
        return salary;
    }
}

class PartTime extends Employee {
    private int hours;
    private double rate;

    public PartTime(String name, int id, int hours, double rate) {
        super(name, id);
        this.hours = hours;
        this.rate = rate;
    }

    public double monthlySalary() {
        return hours * rate;
    }
}

class Intern extends Employee {
    private double stipend;

    public Intern(String name, int id, double stipend) {
        super(name, id);
        this.stipend = stipend;
    }

    public double monthlySalary() {
        return stipend;
    }
}

public class PayrollTest {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of employees: ");
        int n = sc.nextInt();

        Employee[] employees = new Employee[n];

        for (int i = 0; i < n; i++) {

            System.out.println("\nEmployee " + (i + 1));

            System.out.print("Enter name: ");
            String name = sc.next();

            System.out.print("Enter ID: ");
            int id = sc.nextInt();

            System.out.println("1. Full Time");
            System.out.println("2. Part Time");
            System.out.println("3. Intern");

            System.out.print("Enter employee type: ");
            int choice = sc.nextInt();

            if (choice == 1) {

                System.out.print("Enter monthly salary: ");
                double salary = sc.nextDouble();

                employees[i] = new FullTime(name, id, salary);

            }
            
            else if (choice == 2) {

                System.out.print("Enter working hours: ");
                int hours = sc.nextInt();

                System.out.print("Enter rate per hour: ");
                double rate = sc.nextDouble();

                employees[i] = new PartTime(name, id, hours, rate);

            }
            else if (choice == 3) {

                System.out.print("Enter stipend: ");
                double stipend = sc.nextDouble();

                employees[i] = new Intern(name, id, stipend);

            }
            else {
                System.out.println("Invalid choice!");
                i--;
            }
        }

        double total = 0;

        System.out.println("\n--- Payroll ---");

        for (Employee e : employees) {

            double salary = e.monthlySalary();

            System.out.print(
                e.getName() + " (ID " + e.getId() +
                ") salary is " + salary
            );

            if (e instanceof Intern) {
                System.out.print(" [Internship]");
            }

            System.out.println();

            total += salary;
        }

        System.out.println("Total payroll = " + total);

        sc.close();
    }
}