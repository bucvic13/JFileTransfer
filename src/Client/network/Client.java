package Client.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Client
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
        //creates a new Socket with the parametes: ip and port
        socket = new Socket(ip, port);

        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(), true);
        System.out.println("Connected");

        //sets listening true: client is connected with the server
        listening = true;
    }

    //interrupts the conection
    public void disconnect() throws IOException {
        if (socket != null) {
            socket.close();
        }

        socket = null;
        in = null;
        out = null;
        listening = false;
    }

    public String sendCommand(String cmd) throws Exception {

        //checks, if everything is working right
        if (socket != null && in != null && out != null) {

            //parses the command to the Server
            out.println(cmd);
            String response = "";
            try {

                //gets the response from the Server, but only the first line
                response = in.readLine();

                //if there is no response, it cancels
                if (response == null || response.equals("")) {
                    return "";
                }
            } catch (IOException ex) {
                response = "Error: " + ex.getMessage();
            }
            return response;
        }
        throw new Exception("Not connected");
    }

    public String sendLongCommand(String cmd) throws Exception {
        //checks, if everything is working right
        if (socket != null && in != null && out != null) {

            //parses the command to the Server
            out.println(cmd);
            try {
                StringBuilder sb = new StringBuilder();

                //adds each line of the response until "end"
                String response = "";

                while (!(response = in.readLine()).equals("end")) {
                    sb.append(response).append("\n");
                }
                return sb.deleteCharAt(sb.length() - 1).toString();

            } catch (IOException ex) {
                return "Error: " + ex.getMessage();
            }
        }
        throw new Exception("Not connected");
    }

    public String sendCommandWithData(String cmd, String data) throws Exception {
        //checks, if everything is working right
        if (socket != null && in != null && out != null) {

            try {
                out.println(cmd);
                out.println(data);

                String response = in.readLine();
                if (response == null || response.equals("")) {
                    return "";
                }

                return response;

            } catch (IOException ex) {
                return "Error: " + ex.getMessage();
            }
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
