package Server.network;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

/**
 * Server
 *
 * @author Viktoria Buchegger
 * @version 1.0.0
 */
public class Server {

    private final Integer port;
    private final File root;
    private ServerSocket serverSocket;
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

        serverSocket = new ServerSocket(port);
        System.out.println("Server started at port: " + port);

        running = true;

        try {
            while (running) {
                new Handler(serverSocket.accept()).start();
            }

        } finally {
            stop();
        }
    }

    public void stop() throws Exception {
        running = false;
        if (serverSocket != null) {
            serverSocket.close();
            System.out.println("Server stopped");
        }
    }

    private class Handler extends Thread {

        private final Socket socket;
        private BufferedReader in;
        private PrintWriter out;

        public Handler(Socket socket) {
            this.socket = socket;
            System.out.println("New connection with client at " + socket);
        }

        @Override
        public void run() {
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);

                //wait for commands
                while (running) {
                    String command = in.readLine();
                    if (command == null) {
                        break;
                    }

                    try {
                        switch (command) {
                            case "tree":
                                generateXml();
                                break;
                        }
                    } catch (Exception e) {
                        out.printf("Fehler: " + e);
                    }
                }

            } catch (Exception e) {
                System.err.println("Error: " + e);
            } finally {
                try {
                    socket.close();
                } catch (Exception e) {
                    System.err.println("Could not close socket");
                }
                System.out.println("Connection with client closed");
            }
        }

        public void generateXml() {
            //TODO generate XML
            //and return it with out.println(...)
            System.out.println("generate XML");

            Element rootElem = new Element("RootDirectory");
            Document doc = new Document(rootElem);

            for (File elem : root.listFiles()) {
                if (!elem.isDirectory()) {
                    Element file = new Element("File");
//                Attribute size = new Attribute("size= ", "" + <size>);
//                file.setAttribute(size);
                    file.setText(elem.getName());
                    rootElem.addContent(file);
                }
            }

            XMLOutputter xmlOutput = new XMLOutputter();
            xmlOutput.setFormat(Format.getPrettyFormat());
            out.println(xmlOutput); //zurückgeben an client
        }

    }

    public Integer getPort() {
        return port;
    }

    public boolean isRunning() {
        return running;
    }

    public static String getIp() throws UnknownHostException {
        return InetAddress.getLocalHost().getCanonicalHostName();
    }

    public File getRoot() {
        return root;
    }

}
