import org.junit.Test;
import static org.junit.Assert.*;

/*
 Austin Choi
 CS1632 F15
 Deliverable 2
 */

public class Citysim9000Test {
    
    public Citysim9000Test() {
    }

    /**
     * Test valid and invalid arguments for getSeed().
     * Valid arguments are strings containing numbers and only numbers.
     * Invalid arguments are any strings that contain non-numbers or are empty.
     * getSeed() should return an appropriate integer seed for valid arguments.
     * getSeed() should return -1 when fed an invalid argument.
     */
    @Test
    public void testGetSeed() {
        System.out.println("getSeed");
        String validArgs[] = {"-1", "0", "1", String.valueOf(Integer.MAX_VALUE)};
        String invalidArgs[] = { "abc", "123abc", ""};
        for (String arg: validArgs) {
            int observed = Citysim9000.getSeed(arg);
            int expected = Integer.parseInt(arg);
            assertEquals(expected, observed);
        }
        for (String arg: invalidArgs) {
            int observed = Citysim9000.getSeed(arg);
            int expected = -1;
            assertEquals(expected, observed);
        }
    }

    /**
     * spawnDrivers() should create an array of the number of drivers specified.
     * Each driver should be assigned ascending ids, starting from 0.
     * Each driver should be assigned a location from the places array, in order.
     */
    @Test
    public void testSpawnDrivers() {
        System.out.println("spawnDrivers");
        int n = 2;
        Place[] locations = Citysim9000.ALL_PLACES;
        Driver[] observed = Citysim9000.spawnDrivers(n, locations);
        Driver[] expected = {new Driver(0, locations[0]), new Driver(1, locations[1])};
        assertEquals(expected[0].id, observed[0].id);
        assertEquals(expected[0].id, observed[0].id);
        assertEquals(expected[1].location(), observed[1].location());
        assertEquals(expected[1].location(), observed[1].location());
        assertEquals(observed.length, n);
    }
    
}
