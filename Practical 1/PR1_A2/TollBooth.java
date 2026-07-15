import java.util.Scanner;

record Vehicle(String number, String type) {}

public class TollBooth {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int total = 0;
        int bike = 0;
        int car = 0;
        int truck = 0;

        while (true) {

            System.out.print("Enter Vehicle Number (or done): ");
            String number = sc.nextLine();

            if (number.equalsIgnoreCase("done")) {
                break;
            }

            System.out.print("Enter Vehicle Type (bike/car/truck): ");
            String type = sc.nextLine().toLowerCase();

            Vehicle v = new Vehicle(number, type);

            switch (v.type()) {

                case "bike":
                    total += 20;
                    bike++;
                    break;

                case "car":
                    total += 50;
                    car++;
                    break;

                case "truck":
                    total += 150;
                    truck++;
                    break;

                default:
                    System.out.println("Invalid Vehicle Type");
            }
        }

        System.out.println("Total Toll = " + total);

        if (bike == car && car == truck) {
    System.out.println("All vehicle types are equally frequent.");
}
else if (bike == car && bike > truck) {
    System.out.println("Bike and Car are equally frequent.");
}
else if (bike == truck && bike > car) {
    System.out.println("Bike and Truck are equally frequent.");
}
else if (car == truck && car > bike) {
    System.out.println("Car and Truck are equally frequent.");
}
else if (bike > car && bike > truck) {
    System.out.println("Most frequent: Bike");
}
else if (car > bike && car > truck) {
    System.out.println("Most frequent: Car");
}
else {
    System.out.println("Most frequent: Truck");
}

        sc.close();
    }
}