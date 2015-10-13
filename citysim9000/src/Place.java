/*
 Austin Choi
 CS1632 F15
 Deliverable 2
 */

public class Place {
    
    public static final int MAX_PATHS = 2;
    
    private Path paths[];
    public final String name;

    public Place(String name) {
        this.name = name;
        paths = new Path[MAX_PATHS];
    }
    
    /**
     * Returns path at specified index i % number of paths.
     */
    public Path getPath(int i) {
        return paths[i % paths.length];
    }
    
    /**
     * Add the selected path.
     * Returns index of path in array on success.
     * Returns -1 on failure.
     */
    public int addPath(Path p) {
        // Add path to next non-null spot in array
        for (int i = 0; i < paths.length; i++) {
            if (paths[i] == null) {
                paths[i] = p;
                return i;
            }
        }
        return -1;
    }

    public String toString() {
        return name;
    }
    
}
