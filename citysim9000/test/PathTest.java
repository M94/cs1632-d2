import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import static org.mockito.Mockito.*;

/*
 Austin Choi
 CS1632 F15
 Deliverable 2
 */

public class PathTest {
    
    Place src;
    Place dest;
    Place places[];
    
    public PathTest() {
    }
    
    @Before
    public void setUp() throws Exception {
        src = mock(Place.class);
        dest = mock(Place.class);
        places = new Place[]{src, dest};
    }

    /**
     * toString() should return the path's name.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Path path= new Path("Bigelow", places);
        String observed = path.toString();
        String expected = path.name;
        assertEquals(expected, observed);
    }

    /**
     * On a path between two places, src and dest, 
     * from(src) should return dest, and 
     * from(dest) should return src.
     */
    @Test
    public void testFrom() {
        System.out.println("from");
        Path path = new Path("Wall St", places);
        assertEquals(dest, path.from(src));
        assertEquals(src, path.from(dest));
    }
    
}
