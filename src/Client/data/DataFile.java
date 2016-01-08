package Client.data;

/**
 *
 * @author Viktoria Buchegger
 */
public class DataFile {
 
    private final String name;
    private final double size;

    public DataFile(String name, double size) {
        this.name = name;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public double getSize() {
        return size;
    }

    @Override
    public String toString() {
        return String.format("%s ( %10.2f)", name, size);
    }
    
    
    
}
