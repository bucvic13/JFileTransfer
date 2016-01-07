package Client.data;

/**
 *
 * @author Viktoria Buchegger
 */
public enum DataFileEnum {
    
    NAME("Name"),
    SIZE("Size");
    
    private String name;

    private DataFileEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
    
}
