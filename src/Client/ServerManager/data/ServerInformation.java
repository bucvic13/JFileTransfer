package Client.ServerManager.data;

import java.io.Serializable;

/**
 *
 * @author Viktoria Buchegger
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
