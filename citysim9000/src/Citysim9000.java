import java.util.Random;

/*
 Austin Choi
 CS1632 F15
 Deliverable 2
 */

public class Citysim9000 {
    
    public static final Place MALL = new Place("Mall");
    public static final Place BOOKSTORE = new Place("Bookstore");
    public static final Place COFFEE = new Place("Coffee Shop");
    public static final Place UNIVERSITY = new Place("University");
    public static final Place OUTSIDE = new Place("Outside City");
    public static final Place[] ALL_PLACES = {MALL, BOOKSTORE, COFFEE, UNIVERSITY, OUTSIDE};
    
    public static final Path FOURTH_AVE = new Path("Fourth Ave", new Place[]{OUTSIDE, MALL, BOOKSTORE});
    public static final Path FIFTH_AVE = new Path("Fifth Ave", new Place[]{OUTSIDE, UNIVERSITY, COFFEE});
    public static final Path MEOW_ST = new Path("Meow St", new Place[]{MALL, COFFEE});
    public static final Path CHIRP_ST = new Path("Chirp St", new Place[]{BOOKSTORE, UNIVERSITY});
    
    public static final int N_DRIVERS = 4;
    public static final int RAND_BOUND = 2;
    
    public static void main(String[] args) {
        // Get seed
        if (args.length != 1) {
            System.err.println("Please enter an integer seed as the sole argument.");
            System.exit(1);
        }
        int seed = getSeed(args[0]);
        if (seed == -1) {
            System.err.println("Please enter a number for the integer seed.");
            System.exit(1);
        }
        // Create drivers
        Driver drivers[] = spawnDrivers(N_DRIVERS, ALL_PLACES);
        // Create random number generator
        Random rand = new Random(seed);
        // Iterate drivers
        for (Driver driver: drivers) {
            int iteration = 0;
            while ((driver.location() == OUTSIDE && iteration++ > 0) == false) {
                int direction = rand.nextInt(RAND_BOUND);
                System.out.println(driver.drive(direction));
            }
            System.out.println("Driver " + driver.id + " has left the city!\n-----");
        }
    }
    
    /**
     * 
     * @param arg Number in string format
     * @return seed integer on success || -1 if arg not an integer.
     */
    public static int getSeed(String arg) {
        for (int i = 0; i < arg.length(); i++) {
            char c = arg.charAt(i);
            if (c < '0' || c > '9') return -1;
        }
        return Integer.parseInt(arg);
    }
    
    /**
     * @param n Number of drivers to spawn
     * @param locations Places to spawn at
     * @return Array of spawned drivers
     */
    public static Driver[] spawnDrivers(int n, Place locations[]) {
        Driver drivers[] = new Driver[n];
        for (int i = 0; i < n; i++) {
            drivers[i] = new Driver(i, locations[i % locations.length]);
        }
        return drivers;
    }

}