/*
 Austin Choi
 CS1632 F15
 Deliverable 2
 */
public class Driver {
    
    int id;
    Place location;

    public Driver(int id, Place location) {
        this.id = id;
        this.location = location;
    }

    /*
    Return empty string if stuck in the same location.
    */
    public String drive(int direction) {
        System.out.println(location.paths[0]);
        Path path = location.paths[direction % location.paths.length];
        Place source = location;
        Place destination = path.from(source);
        if (destination != source) {
            location = destination;
            return "Driver " + id + " heading from " + source + " to " + destination + " via " + path + ".";
        }
        return "";
    }
    
}
