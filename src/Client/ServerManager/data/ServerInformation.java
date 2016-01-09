package Client.ServerManager.data;

import java.io.Serializable;

/**
 * ServerInformation
 *
 * Dataclass for the ServerInformation
 * 
 * @author Viktoria Buchegger
 * @version 1.0.0
 */


public class ServerInformation implements Serializable {

    private final String ip;
    private final int port;

    public ServerInformation(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }

    public String getIp() {
        return ip;
    }

    public int getPort() {
        return port;
    }

    @Override
    public String toString() {
        return "ServerInformation{" + "ip=" + ip + ", port=" + port + '}';
    }

}
