package protocol;

import commands.CommandData;
import commands.TreeCommand;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

public class ProtocolTest {
    
    public ProtocolTest() {
    }

    @Test
    public void testCreateWelcomeMessage() {
        System.out.println("createWelcomeMessage");
        int id = 5;
        Protocol instance = Protocol.getDefaultInstance();
        String expResult = "Welcome client#5";
        String result = instance.createWelcomeMessage(id);
        assertEquals(expResult, result);
    }

    @Test
    public void testParseWelcomeMessage() {
        System.out.println("parseWelcomeMessage");
        String msg = "Welcome client#6";
        Protocol instance = Protocol.getDefaultInstance();
        int expResult = 6;
        int result = instance.parseWelcomeMessage(msg);
        assertEquals(expResult, result);
    }

    @Test
    public void testCreateCommand() throws Exception {
        System.out.println("createCommand");
        Class name = TreeCommand.class;
        List<String> param = new ArrayList<>();
        param.add("param1");
        param.add("param2");
        
        Protocol instance = Protocol.getDefaultInstance();
        String expResult = "tree:param1 param2";
        String result = instance.createCommand(name, param);
        assertEquals(expResult, result);
    }

    @Test
    public void testParseCommand() throws Exception {
        System.out.println("parseCommand");
        String cmd = "tree:param1 param2";
        Protocol instance = Protocol.getDefaultInstance();
        List<String> parameter = new ArrayList<>();
        parameter.add("param1");
        parameter.add("param2");
        CommandData expResult = new CommandData(instance.getCommandByName("tree"), parameter);
        CommandData result = instance.parseCommand(cmd);
        assertEquals(expResult, result);
    }
}
