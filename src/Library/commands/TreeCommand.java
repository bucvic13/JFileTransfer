package Library.commands;

import Client.model.ClientModel;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdom2.*;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

/**
 *
 * @author Viktoria Buchegger
 */
public class TreeCommand extends Command {

    private static final String NAME = "tree";
    private ClientModel model;

    public TreeCommand() {
        super(NAME);
    }

    @Override
    public void execute(File rootDir, PrintWriter out) {
        //TODO generate XML file
        //and returns it with out.println(...)
        System.out.println("generate XML");

        Element root = new Element("RootDirectory");
        Document doc = new Document(root);

        for (File elem : rootDir.listFiles()) {
            if (!elem.isDirectory()) {
                Element file = new Element("File");
//                Attribute size = new Attribute("size= ", "" + elem.getTotalSpace());
//                file.setAttribute(size);
                file.setText(elem.getName());
                root.addContent(file);
            }
        }

        XMLOutputter xmlOutput = new XMLOutputter();
        xmlOutput.setFormat(Format.getPrettyFormat());
        out.println(xmlOutput);

        model = new ClientModel();

        try {

            xmlOutput.output(doc, System.out);
            model.loadFiles(rootDir);

        } catch (IOException ex) {
            System.out.println("Problem here");
        } catch (JDOMException ex) {
            Logger.getLogger(TreeCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
