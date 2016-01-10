package Server.network;

import Client.bl.CalculateFileSize;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdom2.Attribute;
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

    //starts the server
    public void start() throws Exception {

        //checks if the server is alread running
        if (running) {
            throw new Exception("Server is already running");
        }

        //creates a new ServerSocket at the port xxx
        serverSocket = new ServerSocket(port);
        System.out.println("Server started at port: " + port);

        running = true;

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (running) {
                    try {
                        //creates a new Handler 
                        new Handler(serverSocket.accept()).start();
                    } catch (IOException ex) {
                        Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }).start();
    }

    //stops the server 
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
                //to get things from the server
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                //for returning things to the client
                out = new PrintWriter(socket.getOutputStream(), true);

                //wait for commands
                while (running) {

                    //reads the command from the Server, only the first line
                    String command = in.readLine();

                    //if there is no command, the server stops
                    if (command == null) {
                        break;
                    }

                     String parameter = "";
                    
                     //checks if there are any parameters behind the command
                    if (command.contains("#")) {
                        String commandoParts[] = command.split("#");
                        //returns the command
                        command = commandoParts[0];
                        //returns the parameter
                        parameter = commandoParts[1];
                    }

                    try {
                        switch (command) {
                            case "tree":
                                generateXml();
                                break;
                            case "get":
                                //System.out.println("command get: " + parameter);
                                String base = root.getCanonicalPath();
                                base = base + System.getProperty("file.separator");
                                //System.out.println("get base: " + base + parameter);
                                String response = readFile(base + parameter);
                                
                                FileWriter fw = new FileWriter(base + parameter + ".parsed");
                                fw.write(response);
                                fw.flush();
                                fw.close();
                                
                                out.println(response);
                                out.println("end");
                                break;
                        }

                    } catch (Exception e) {
                        out.printf("Error: " + e);
                    }
                }

            } catch (Exception e) {
                System.err.println("Error: " + e);
            } finally {
                try {
                    //trys to close the socket
                    socket.close();
                } catch (Exception e) {
                    System.err.println("Could not close socket");
                }
                System.out.println("Connection with client closed");
            }
        }

        //generates XML
        public void generateXml() {
            //Template of the XML:  <RootDirectory><File size="17">Datei.txt</File></RootDirectory>
            System.out.println("Generate XML");

            //creates the RootElement <RootDirectory>
            Element rootElem = new Element("RootDirectory");
            Document doc = new Document(rootElem);

            for (File elem : root.listFiles()) {
                if (!elem.isDirectory()) {
                    //creates the Element <File>
                    Element file = new Element("File");

                    //with calcFileSize() the size of the file has to be calculated
                    double size = CalculateFileSize.calcFileSize(elem);

                    //creates the Attribute size with the calulculatet size of the file
                    Attribute sizeAtt = new Attribute("size", "" + size);
                    file.setAttribute(sizeAtt);
                    file.setText(elem.getName());
                    //adds the new file to the RootElement
                    rootElem.addContent(file);
                }
            }
            XMLOutputter xmlOutput = new XMLOutputter();
            xmlOutput.setFormat(Format.getCompactFormat());

            //parses the XMLOutputter into a String
            String output = xmlOutput.outputString(doc);
            //puts the whole xml in one line, because only the first line will be readed in the Client 
            output = output.replace("\n", "").replace("\r", "");

            //returns it with out.println(...)
            out.println(output);
        }

        private String readFile(String path) throws IOException {
            byte[] encoded = Files.readAllBytes(Paths.get(path));
            return new String(encoded);
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
