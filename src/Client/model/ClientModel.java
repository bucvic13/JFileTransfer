package Client.model;

import Client.data.DataFile;
import Client.data.DataFileEnum;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

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
        //TODO parse response xml

        SAXBuilder builder = new SAXBuilder();
        Document doc = (Document) builder.build(new ByteArrayInputStream(response.getBytes()));

        Element rootNode = doc.getRootElement();
        List list = rootNode.getChildren("File");

        for (int i = 0; i < list.size(); i++) {
            Element node = (Element) list.get(i);
            double size = Double.parseDouble(node.getChildText("size"));

            System.out.println("File-Name: " + node.getText());
            System.out.println("File-Size: " + size);
            dataFiles.add(new DataFile(node.getText(), size));

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
                return data.getSize();
            default:
                return "???";
        }
    }

}
