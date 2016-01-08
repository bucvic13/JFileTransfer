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
import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

/**
 *
 * @author Viktoria Buchegger
 */
public class ClientModel extends AbstractTableModel {

    private List<DataFile> dataFiles = new LinkedList<>();

    public void addTestdaten() {
        dataFiles.add(new DataFile("File1", 40));
        dataFiles.add(new DataFile("File2", 50));
        dataFiles.add(new DataFile("File3", 408));
        dataFiles.add(new DataFile("File4", 790));
        super.fireTableDataChanged();
    }

    public void parseResponse(String response) throws JDOMException, IOException {
        SAXBuilder builder = new SAXBuilder();
        Document doc = (Document) builder.build(new ByteArrayInputStream(response.getBytes()));

        Element rootNode = doc.getRootElement();
        List list = rootNode.getChildren("File");

        for (int i = 0; i < list.size(); i++) {
            Element node = (Element) list.get(i);
            double size = Double.parseDouble(node.getAttributeValue("size"));

            System.out.println("File-Name: " + node.getText());
            System.out.println("File-Size: " + size);
            dataFiles.add(new DataFile(node.getText(), size));
        }
        super.fireTableDataChanged();
    }

    public void getLocalDatas(File root)
    {
         for (File elem : root.listFiles()) {
                if (!elem.isDirectory()) {

                    String name = elem.getName();
                    double size = CalculateFileSize.calcFileSize(elem);
                    dataFiles.add(new DataFile(name, size));
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

    public DataFile getElement(int rowIndex) {

        DataFile data = dataFiles.get(rowIndex);
        return data;

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

    public void DateFromServerToClient(DataFile data, String localPath) {
        
        dataFiles.add(data);
        super.fireTableDataChanged();
    }

}
