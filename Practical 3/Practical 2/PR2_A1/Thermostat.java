public class Thermostat {
    
    private String location;
    private int temperature;
    private static final int MIN = 16;
    private static final int MAX = 30;
    private static int activeCount = 0;

    
    public Thermostat(String location, int startTemp) {
        this.location = location;
        if (startTemp >= MIN && startTemp <= MAX) {
            this.temperature = startTemp;
        } else {
            this.temperature = 22;
        }
        activeCount++;
    }

    
    public Thermostat(String location) {
        this(location, 22);
    }

  
    public void raise() {
        if (this.temperature < MAX) {
            this.temperature += 1;
        } else {
            System.out.println("Already at maximum (" + MAX + ")");
        }
    }

  
    public void lower() {
        if (this.temperature > MIN) {
            this.temperature -= 1;
        } else {
            System.out.println("Already at minimum (" + MIN + ")");
        }
    }

   
    public int getTemperature() {
        return this.temperature;
    }

  
    public static int getActiveCount() {
        return activeCount;
    }

   
    public static void main(String[] args) {
        // Create two thermostats
        Thermostat livingRoom = new Thermostat("Living Room", 22);
        Thermostat bedroom = new Thermostat("Bedroom");

        System.out.println("Testing livingRoom thermostat:");
        
        // Call raise() 10 times in a loop, printing the temperature each time
        System.out.println("Raising temperature...");
        for (int i = 0; i < 10; i++) {
            livingRoom.raise();
            System.out.println("Current temp: " + livingRoom.getTemperature());
        }

      
        System.out.println("\nLowering temperature...");
        for (int i = 0; i < 20; i++) {
            livingRoom.lower();
            System.out.println("Current temp: " + livingRoom.getTemperature());
        }

       
        System.out.println("\nTotal active thermostats: " + Thermostat.getActiveCount());
    }
}