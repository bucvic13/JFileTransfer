package Client.ServerManager.model;

import Client.ServerManager.data.ServerInformation;
import Client.ServerManager.data.ServerManagerEnum;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 * ServerManagerModel
 *
 * Modelclass for the ServerManager
 * 
 * @author Viktoria Buchegger
 * @version 1.0.0
 */
public class ServerManagerModel extends AbstractTableModel {

    private List<ServerInformation> servers = new LinkedList<>();

    public ServerManagerModel() throws Exception {
        //only for testing 
        addTestdatas();  
    }

    private void addTestdatas() throws Exception {
        add(new ServerInformation("127.0.0.1", 8530));
        add(new ServerInformation("128.0.0.1", 9530));
        add(new ServerInformation("129.0.0.1", 7530));
    }

    public void add(ServerInformation data) throws Exception {
        checkIfDataAlreadyExists(data);
        servers.add(data);
        super.fireTableDataChanged();
    }

    public void remove(int index) {
        servers.remove(index);
        super.fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return servers.size();
    }

    @Override
    public int getColumnCount() {
        return ServerManagerEnum.values().length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ServerManagerEnum e = ServerManagerEnum.values()[columnIndex];
        ServerInformation data = servers.get(rowIndex);

        switch (e) {
            case IP:
                return data.getIp();
            case PORT:
                return data.getPort();
            default:
                return "???";
        }
    }

    public void set(int index, ServerInformation data) {
        servers.set(index, data);
        super.fireTableDataChanged();
    }

    public ServerInformation get(int index) {
        return servers.get(index);
    }

    @Override
    public String getColumnName(int column) {
        return ServerManagerEnum.values()[column].getName();
    }

    @Override
    public boolean isCellEditable(int row, int col) {
        ServerManagerEnum enumIndex = ServerManagerEnum.values()[col];

        switch (enumIndex) {
            case IP:
                return true;
            case PORT:
                return true;
        }

        return false;
    }

    @Override
    public void setValueAt(Object o, int row, int col) { 
            ServerInformation serverOld = servers.get(row);
            ServerManagerEnum e = ServerManagerEnum.values()[col];

            //safe the old values
            String ip = serverOld.getIp();
            int port = serverOld.getPort();

            switch (e) {
                case IP:
                    ip = (String) o;
                    break;
                case PORT:
                    port = Integer.parseInt((String) o);
                    break;
            }

            int index = servers.indexOf(serverOld);

            ServerInformation newServer = new ServerInformation(ip, port);

            servers.set(index, newServer);
            super.fireTableDataChanged();
    }

    //Saves all the data from the list in a file
    public void save(File file) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));

        for (ServerInformation s : servers) {
            oos.writeObject(s);
        }
        oos.flush();
        oos.close();
    }

    //Loads the data from a file and safes it in the list
    public void load(File file) throws FileNotFoundException, IOException, ClassNotFoundException, Exception {
        servers.clear();

        if (!file.exists()) {
            file.createNewFile();
        }

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        ServerInformation s = null;

        do {
            s = (ServerInformation) ois.readObject();
            if (s != null) {
                this.add(s);
            }
        } while (s != null);
    }

    //checks if the the Data is already in the list, if yes it return an Exception
    public void checkIfDataAlreadyExists(ServerInformation data) throws Exception {
        for (ServerInformation server : servers) {
            if (server.getIp().equals(data.getIp()) && server.getPort() == data.getPort()) {
                throw new Exception("Data already exists");
            }
        }
    }

}
