package commands;

import java.io.File;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

public class CommandTest {
    
    public CommandTest() {
    }
    @Test
    public void testMake() {
        System.out.println("make");
        List<String> parameter = new LinkedList<>();
        parameter.add("param1");
        parameter.add("param2");
        
        Command instance = new CommandImpl();
        String expResult = "test:param1 param2";
        String result = instance.make(parameter);
        assertEquals(expResult, result);
    }

    public class CommandImpl extends Command {

        public CommandImpl() {
            super("test");
        }

        public void execute(File root, PrintWriter out) {
        }
    }
    
}
