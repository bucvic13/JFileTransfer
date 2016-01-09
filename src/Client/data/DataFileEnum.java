package Client.data;

/**
 * DataFileEnum
 *
 * Enumclass for the colummn-Heading in ClientGUI
 * 
 * @author Viktoria Buchegger
 * @version 1.0.0
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
