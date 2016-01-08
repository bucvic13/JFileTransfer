package Client.ServerManager.data;

/**
 *
 * @author Viktoria Buchegger
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
