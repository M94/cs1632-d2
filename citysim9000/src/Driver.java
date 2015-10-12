/*
 Austin Choi
 CS1632 F15
 Deliverable 2
 */
public class Driver {
    
    public final int id;
    private Place location;

    public Driver(int id, Place location) {
        this.id = id;
        this.location = location;
    }
    
    public Place location() {
        return location;
    }

    /**
     * Go to next location on path.
     * @param direction Determines path from location
     * @return Status update if successful || Empty string if stuck in the same location
     */
    public String drive(int direction) {
        Path path = location.getPath(direction);
        Place source = location;
        Place destination = path.from(source);
        if (destination != source) {
            location = destination;
            return "Driver " + id + " heading from " + source + " to " + destination + " via " + path + ".";
        }
        return "";
    }
    
}
