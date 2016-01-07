package Client.model;

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

    public void loadFiles(File rootDir) throws IOException, JDOMException {

        System.out.println("loadFiles");
        System.out.println("RootDir: " + rootDir);
//
//        File inputFile = new File("src/xmlfiles/files.xml");
//        SAXBuilder saxBuilder = new SAXBuilder();
//        Document document = saxBuilder.build(inputFile);
//
//        System.out.println("Root element :"
//                + root.getName());
//
//        List<Element> tmpList = root.getChildren();
//
//        for (int i = 0; i < tmpList.size(); i++) {
//            Element file = tmpList.get(i);
//            String textContent = file.getText();
//            System.out.println("File-name " + textContent);
//        }

        SAXBuilder builder = new SAXBuilder();
        File xmlFile = new File("\\src\\Library\\xmlfiles\\files.xml");

        Document document = (Document) builder.build(xmlFile);
        Element rootNode = document.getRootElement();
        List list = rootNode.getChildren("File");

        for (int i = 0; i < list.size(); i++) {

            Element node = (Element) list.get(i);
            System.out.println("File Name : " + node.getName());

        }
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
