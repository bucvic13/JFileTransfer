package Client.model;

import Client.bl.CalculateFileSize;
import Client.data.DataFile;
import Client.data.DataFileEnum;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

/**
 * ClientModel
 *
 * @author Viktoria Buchegger
 * @version 1.0.0
 */
public class ClientModel extends AbstractTableModel {

    private List<DataFile> dataFiles = new LinkedList<>();

    //only for testing
    public void addTestdaten() {
        add(new DataFile("File1", 40));
        add(new DataFile("File2", 50));
        add(new DataFile("File3", 408));
        add(new DataFile("File4", 790));
    }

    //adds an Element to the list
    public void add(DataFile data) {
        dataFiles.add(data);
        super.fireTableDataChanged();
    }

    //return an Element from the list
    public DataFile get(int rowIndex) {
        DataFile data = dataFiles.get(rowIndex);
        return data;
    }

    //gets the data from the xml and adds it to the list
    public void parseResponse(String response) throws JDOMException, IOException {
        SAXBuilder builder = new SAXBuilder();
        Document doc = (Document) builder.build(new ByteArrayInputStream(response.getBytes()));

        //returns the RootElement: <RootDirectory>
        Element rootNode = doc.getRootElement();
        
        //adds all Children <File> from the RootElement to the list
        List list = rootNode.getChildren("File");

        //runs through the list until the end of it
        for (int i = 0; i < list.size(); i++) {
            
            //gets the item from the list and parses it into an Element
            Element node = (Element) list.get(i);
            
            //returns the value of the Attribute size
            double size = Double.parseDouble(node.getAttributeValue("size"));

            System.out.println("File-Name: " + node.getText());
            System.out.println("File-Size: " + size);
            
            //adds the element to the list
            add(new DataFile(node.getText(), size));
        }
        super.fireTableDataChanged();
    }

    //gets the data from the local path and adds it to the list
    public void getLocalDatas(File root) {
        
        //continues until the last elem is added
        for (File elem : root.listFiles()) {
            if (!elem.isDirectory()) {
                
                //gets the Name of the file
                String name = elem.getName();
                
                //calls the static Method calcFileSize() to calculate the size of the file
                double size = CalculateFileSize.calcFileSize(elem);
                add(new DataFile(name, size));
            }
        }
        super.fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return dataFiles.size();
    }

    @Override
    public int getColumnCount() {
        return DataFileEnum.values().length;
    }

    @Override
    public String getColumnName(int column) {
        return DataFileEnum.values()[column].getName();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        DataFileEnum e = DataFileEnum.values()[columnIndex];
        DataFile data = dataFiles.get(rowIndex);

        switch (e) {
            case NAME:
                return data.getName();
            case SIZE:
                return String.format("%10.2f KB", data.getSize());
            default:
                return "???";
        }
    }

    public void addFromServerToClient(DataFile data) {
        add(data);
        super.fireTableDataChanged();
    }

}
