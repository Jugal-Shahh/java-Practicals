public class ParkingLot {
    private int twoWheelers;
    private int fourWheelers;
    private final int twoCap;
    private final int fourCap;
    private static long revenue = 0;

    public ParkingLot(int twoCap, int fourCap) {
        this.twoCap = twoCap;
        this.fourCap = fourCap;
        this.twoWheelers = 0;
        this.fourWheelers = 0;
    }

    public void park(String type) {
        if (type.equals("two")) {
            if (this.twoWheelers < this.twoCap) {
                this.twoWheelers++;
                revenue += 20;
                System.out.println("Parked a two-wheeler successfully.");
            } else {
                System.out.println("Full");
            }
        } else if (type.equals("four")) {
            if (this.fourWheelers < this.fourCap) {
                this.fourWheelers++;
                revenue += 40;
                System.out.println("Parked a four-wheeler successfully.");
            } else {
                System.out.println("Full");
            }
        } else {
            System.out.println("Invalid vehicle type.");
        }
    }

    public void leave(String type) {
        if (type.equals("two")) {
            if (this.twoWheelers > 0) {
                this.twoWheelers--;
                System.out.println("A two-wheeler left.");
            }
        } else if (type.equals("four")) {
            if (this.fourWheelers > 0) {
                this.fourWheelers--;
                System.out.println("A four-wheeler left.");
            }
        } else {
            System.out.println("Invalid vehicle type.");
        }
    }

    public int getTwoWheelers() {
        return this.twoWheelers;
    }

    public int getFourWheelers() {
        return this.fourWheelers;
    }

    public static long getRevenue() {
        return revenue;
    }

    public static void main(String[] args) {
        ParkingLot lot = new ParkingLot(2, 1);

        lot.park("two");
        lot.park("two");
        lot.park("two"); 

        lot.park("four");
        lot.park("four"); 

        lot.leave("two");
        lot.park("two"); 

        lot.leave("four");
        lot.leave("four"); 

        System.out.println("\n--- Final Status ---");
        System.out.println("Two-wheelers currently parked: " + lot.getTwoWheelers());
        System.out.println("Four-wheelers currently parked: " + lot.getFourWheelers());
        System.out.println("Total revenue collected: " + ParkingLot.getRevenue());
    }
}