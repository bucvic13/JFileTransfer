package network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import protocol.Protocol;

/**
 * Server
 *
 * @author Viktoria Buchegger
 * @version 1.0.0
 */
public class Client {

    private final String ip;
    private final int port;
    private boolean listening;
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;

    public Client(String ip, Integer port) {
        this.ip = ip;
        this.port = port;
        this.listening = false;
        this.socket = null;
        this.in = null;
        this.out = null;
    }

    public void connect() throws IOException {
        socket = new Socket(ip, port);
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(), true);
        int id = Protocol.getDefaultInstance().parseWelcomeMessage(in.readLine());
        System.out.println("Connected as client #" + id);
        listening = true;
    }
    
    public void disconnect() throws IOException {
        if(socket != null) {
            socket.close();
        }
        socket = null;
        in = null;
        out = null;
        listening = false;
    }
    
    public String sendCommand(String cmd) throws Exception {
        if(socket != null && in != null && out != null) {
            out.println(cmd);
            String response;
            try {
                response = in.readLine();
                if(response == null || response.equals("")) {
                    return "";
                }
            } catch(IOException ex) {
                response = "Error: " + ex.getMessage();
            }
            return response;
        }
        throw new Exception("Not connected");
    }

    public String getIp() {
        return ip;
    }

    public int getPort() {
        return port;
    }

    public boolean isListening() {
        return listening;
    }
}
