package Client.model;

import Client.data.DataFile;
import Client.data.DataFileEnum;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import org.jdom2.Document;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

/**
 *
 * @author Viktoria Buchegger
 */
public class ClientModel extends AbstractTableModel {

    private List<DataFile> dataFiles = new LinkedList<>();

    public void addTestdaten() {
        dataFiles.add(new DataFile("File1", "40"));
        dataFiles.add(new DataFile("File2", "50"));
        dataFiles.add(new DataFile("File3", "408"));
        dataFiles.add(new DataFile("File4", "790"));
        super.fireTableDataChanged();
    }

    
    public void parseResponse(String response) throws JDOMException, IOException {
        //TODO parse response xml
        
        SAXBuilder builder = new SAXBuilder();
        Document doc = (Document) builder.build(new ByteArrayInputStream(response.getBytes()));
        //TODO weitermachen
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
    public String getColumnName(int column
    ) {

        return DataFileEnum.values()[column].getName();
    }

    public DataFile getElement(int rowIndex) {

        DataFile data = dataFiles.get(rowIndex);
        return data;

    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return null;
    }

}
