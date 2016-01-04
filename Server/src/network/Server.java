package network;

import commands.CommandData;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import protocol.Protocol;

/**
 * Server
 *
 * @author Markus Petritz
 * @version 1.0.0
 */
public class Server {

    private final Integer port;
    private final File root;
    private ServerSocket listener;
    private boolean running;

    public Server(Integer port, File root) {
        this.port = port;
        this.root = root;
        this.running = false;
    }

    public void start() throws Exception {
        if (running) {
            throw new Exception("Server is already running");
        }
        running = true;
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    int client = 0;
                    listener = new ServerSocket(port);
                    System.out.println("Server started at port: " + port);
                    
                    try {
                        while (running) {
                            new Handler(listener.accept(), client++).start();
                        }
                    } finally {
                        stop();
                    }
                } catch (Exception ex) {
                    System.err.println(ex);
                }
            }
        }).start();
    }

    public void stop() throws IOException {
        running = false;
        if(listener != null) {
            listener.close();
            System.out.println("Server stopped");
        }
    }

    public Integer getPort() {
        return port;
    }

    public static String getIp() throws UnknownHostException {
        return InetAddress.getLocalHost().getCanonicalHostName();
    }

    public boolean isRunning() {
        return running;
    }

    private class Handler extends Thread {

        private final Socket socket;
        private final int client;
        private final Protocol protocol;

        public Handler(Socket socket, int client) {
            this.socket = socket;
            this.client = client;
            this.protocol = Protocol.getDefaultInstance();
            //TODO: write logger class
            System.out.println("New connection with client #" + this.client + " at " + socket);
        }

        @Override
        public void run() {
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

                out.println(protocol.createWelcomeMessage(client));

                //wait for commands
                while (running) {
                    String command = in.readLine();
                    if (command == null) {
                        break;
                    }

                    //Log
                    System.out.println("Got command: " + command);

                    try {
                        CommandData data = protocol.parseCommand(command);
                        data.execute(root, out);
                    } catch (Exception ex) {
                        out.println(protocol.createErrorMessage(ex.getMessage()));
                    }
                }

            } catch (IOException ex) {
                System.err.println("Error handling client #" + client + ": " + ex);
            } finally {
                try {
                    socket.close();
                } catch (IOException ex) {
                    System.err.println("Could not close socket");
                }
                System.out.println("Connection with client #" + client + " closed");
            }
        }
    }
}
