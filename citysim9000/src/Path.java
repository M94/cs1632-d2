public class Path {
    
    public final String name;
    private Place places[];

    public Path(String name, Place places[]) {
        this.name = name;
        this.places = places;
        for (Place p: places) p.addPath(this);
    }
    
    public String toString() {
        return name;
    }
    
    /*
    Returns next possible location from source.
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
