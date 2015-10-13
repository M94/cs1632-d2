import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import static org.mockito.Mockito.*;

/*
 Austin Choi
 CS1632 F15
 Deliverable 2
 */

public class DriverTest {
    
    private Driver driver;
    private Path path1;
    private Path path2;
    private Place place1;
    private Place place2;
    
    public DriverTest() {
    }

    @Before
    public void setUp() throws Exception {
        place1 = mock(Place.class);
        place2 = mock(Place.class);
        path1 = mock(Path.class);
        path2 = mock(Path.class);
        // Place1 & place2 have two two-way streets between them
        when(place1.getPath(0)).thenReturn(path1);
        when(place1.getPath(1)).thenReturn(path2);
        when(place2.getPath(0)).thenReturn(path1);
        when(place2.getPath(1)).thenReturn(path2);
        // Path1 
        when(path1.from(place1)).thenReturn(place2);
        when(path1.from(place2)).thenReturn(place1);
        // Path2 
        when(path2.from(place1)).thenReturn(place2);
        when(path2.from(place2)).thenReturn(place1);        
    }
    

    @Test
    public void testLocation() {
        System.out.println("location");
        driver = new Driver(0, place1);
        Place expected = place1;
        Place observed = driver.location();
        assertEquals(expected, observed);
    }

    @Test
    public void testDrive() {
        System.out.println("drive");
        int args[] = {0, 1};
        for (int arg: args) {
             driver = new Driver(0, place1);
             String observed = driver.drive(arg);
             assertFalse(observed == "");
             assertEquals(place2, driver.location());
        }
    }
    
}
