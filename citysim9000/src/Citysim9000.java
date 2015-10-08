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
    
    public static final Path FOURTH_AVE = new Path("Fourth Ave", new Place[]{OUTSIDE, MALL, BOOKSTORE});
    public static final Path FIFTH_AVE = new Path("Fifth Ave", new Place[]{OUTSIDE, UNIVERSITY, COFFEE});
    public static final Path MEOW_ST = new Path("Meow St", new Place[]{MALL, COFFEE});
    public static final Path CHIRP_ST = new Path("Chirp St", new Place[]{BOOKSTORE, UNIVERSITY});
    
    public static final int N_DRIVERS = 4;
    
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
        Place startLoc[] = {MALL, BOOKSTORE, COFFEE, UNIVERSITY, OUTSIDE};
        Driver drivers[] = spawnDrivers(N_DRIVERS, startLoc);
        // Iterate drivers
        for (Driver driver: drivers) {
            do {
                System.out.println(driver.drive(0));
            } while (driver.location != OUTSIDE);
        }
    }
    
    /*
    Returns -1 if not an integer.
    */
    public static int getSeed(String arg) {
        for (int i = 0; i < arg.length(); i++) {
            char c = arg.charAt(i);
            if (c < '0' || c > '9') return -1;
        }
        return Integer.parseInt(arg);
    }
    
    public static Driver[] spawnDrivers(int n, Place locations[]) {
        Driver drivers[] = new Driver[n];
        for (int i = 0; i < n; i++) {
            drivers[i] = new Driver(i, locations[i % locations.length]);
        }
        return drivers;
    }

}