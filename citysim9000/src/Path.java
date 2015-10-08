public class Path {
    
    public String name;
    private Place places[];

    public Path(String name, Place places[]) {
        this.name = name;
        this.places = places;
        // Add path reference to each place
        for (Place p: places) {
            for (int i = 0; i < p.paths.length; i++) {
                if (p.paths[i] == null) {
                    p.paths[i] = this;
                    continue;
                }
            }
        }
    }
    
    public String toString() {
        return name;
    }
    
    /*
    Returns source if no destination possible
    */
    public Place from(Place source) {
        for (int i = 0; i < places.length; i++) {
            if (places[i] == source) {
                return places[(i + 1) % places.length];
            }
        }
        return source;
    }
    
}
