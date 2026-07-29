public class CinemaShow {
    
    private String title;
    private int seatsAvailable;
    private final int capacity;
    private static int totalBooked = 0;

    
    public CinemaShow(String title, int capacity) {
        this.title = title;
        this.capacity = capacity;
        this.seatsAvailable = capacity;
    }

    
    public CinemaShow(String title) {
        this(title, 100);
    }

    
    public boolean book(int n) {
        if (n <= this.seatsAvailable) {
            this.seatsAvailable -= n;
            totalBooked += n;
            return true;
        }
        return false;
    }

   
    public void cancel(int n) {
        int seatsToRestore = n;
        // Cap the restoration so seatsAvailable doesn't cross capacity
        if (this.seatsAvailable + n > this.capacity) {
            seatsToRestore = this.capacity - this.seatsAvailable;
        }
        
        this.seatsAvailable += seatsToRestore;
        totalBooked -= seatsToRestore;
    }

    
    public int getSeatsAvailable() {
        return this.seatsAvailable;
    }

    // (e) Static getter for total global bookings
    public static int getTotalBooked() {
        return totalBooked;
    }

   
    public static void main(String[] args) {
        // Create a cinema show with a capacity of 50
        CinemaShow show = new CinemaShow("Inception", 50);

        System.out.println("Initial seats available: " + show.getSeatsAvailable());

        
        System.out.println("\nBooking 30 seats...");
        boolean res1 = show.book(30);
        System.out.println("Result: " + res1 + " | Seats left: " + show.getSeatsAvailable());


        System.out.println("\nBooking 25 seats (only 20 left)...");
        boolean res2 = show.book(25);
        System.out.println("Result: " + res2 + " | Seats left: " + show.getSeatsAvailable());

       
        System.out.println("\nCanceling 10 seats...");
        show.cancel(10);
        System.out.println("Seats left after cancel: " + show.getSeatsAvailable());

      
        System.out.println("\nBooking 15 seats...");
        boolean res3 = show.book(15);
        System.out.println("Result: " + res3 + " | Seats left: " + show.getSeatsAvailable());

       
        System.out.println("\n--- Final Summary ---");
        System.out.println("Total successful seats booked globally: " + CinemaShow.getTotalBooked());
    }
}