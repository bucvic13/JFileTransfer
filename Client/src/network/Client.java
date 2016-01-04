package network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Server
 *
 * @author Viktoria Buchegger
 * @version 1.0.0
 */
public class Client {

    private final String ip;
    private final int port;
    private BufferedReader in;
    private PrintWriter out;
    private String response;

    public Client(String ip, Integer port) {
        this.ip = ip;
        this.port = port;

    }

    public void connectToServer() throws IOException {

        Socket socket = new Socket(ip, port);
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(), true);
        
        //wie funktioniert das mit der Message ?
    }

    public String getIp() {
        return ip;
    }

    public int getPort() {
        return port;
    }

    public String getResponse() {
        return response;
    }
    
    

}
