package Client.ServerManager.data;

/**
 * ServerManagerEnum
 *
 * Enumclass for the Colummn - Heading of the Table for the ServerManager
 * 
 * @author Viktoria Buchegger
 * @version 1.0.0
 */
public enum ServerManagerEnum {
    
    IP("IP"),
    PORT("Port");
    
    private String name;

    private ServerManagerEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
    
}
