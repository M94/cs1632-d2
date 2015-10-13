import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/*
 Austin Choi
 CS1632 F15
 Deliverable 2
 */

public class PlaceTest {
    
    private Path path1;
    
    public PlaceTest() {
    }
    
    @Before
    public void setUp() {
        path1 = mock(Path.class);
    }

    /**
     * getPath() should return null if place has no paths.
     */
    @Test
    public void testGetPath() {
        Place place = new Place("Nowhere");
        assertEquals(null, place.getPath(0));
        System.out.println("getPath");

    }

    /**
     * addPath() should return the respective index of a newly added path.
     * It should return -1 when we try to add more paths than allowed.
     */
    @Test
    public void testAddPath() {
        System.out.println("addPath");
        Place place = new Place("Somewhere");
        for (int i = 0; i < Place.MAX_PATHS; i ++) {
            int observed = place.addPath(path1);
            int expected = i;
            assertEquals(expected ,observed);
        }
        int observed = place.addPath(path1);
        int expected = -1;
        assertEquals(expected ,observed);
    }

    /**
     * toString() should return the place's name.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Place place = new Place("Neverland");
        String observed = place.toString();
        String expected = place.name;
        assertEquals(expected, observed);
    }
    
}
