public class Place {
    
    public Path paths[];
    public String name;

    public Place(String name) {
        this.name = name;
        paths = new Path[2];
    }

    public String toString() {
        return name;
    }
    
}
