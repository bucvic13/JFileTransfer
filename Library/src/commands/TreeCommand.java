package commands;

import java.io.File;
import java.io.PrintWriter;

public class TreeCommand extends Command {

    private static final String NAME = "tree";
    
    public TreeCommand() {
        super(NAME);
    }

    @Override
    public void execute(File root, PrintWriter out) {
        out.println("got tree request");
        
        //TODO generate XML file
        //and returns it with out.println(...)
    }
    
}
