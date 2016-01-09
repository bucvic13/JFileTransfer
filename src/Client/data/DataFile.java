package Client.data;

/**
 * DataFile
 *
 * Dataclass for the ClientModel
 * 
 * @author Viktoria Buchegger
 * @version 1.0.0
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
