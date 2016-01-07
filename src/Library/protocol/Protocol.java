package Library.protocol;

import Library.commands.Command;
import Library.commands.CommandData;
import Library.commands.TreeCommand;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Viktoria Buchegger
 */
public class Protocol {

    private static Protocol instance;
    private final Map<String, Command> commands;

    private Protocol() {
        this.commands = new HashMap<>();
        loadDefaultCommands();
    }

    public static Protocol getDefaultInstance() {
        if (instance == null) {
            instance = new Protocol();
        }

        return instance;
    }

    /**
     * Creates welcome message with the client id
     *
     * @param id
     * @return
     */
    public String createWelcomeMessage(int id) {
        return String.format("Welcome client #%d", id);
    }

    /**
     * Parses Welcome message, if client id could not be detected returns -1
     *
     * @param msg
     * @return
     */
    public int parseWelcomeMessage(String msg) {
        try {
            return Integer.parseInt(msg.substring(msg.indexOf("#") + 1));
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    /**
     * Creaters error messages
     *
     * @param msg
     * @return
     */
    public String createErrorMessage(String msg) {
        return String.format("Error: %s", msg);
    }

    /**
     * parses error message
     *
     * @param msg
     * @return
     */
    public String parseErrorMessage(String msg) {
        return msg.substring(msg.indexOf(":"), msg.length());
    }

    /**
     * Creates command by class and parameter
     *
     * @param name
     * @param param
     * @return
     * @throws Exception
     */
    public String createCommand(Class<?> name, List<String> param) throws Exception {
        return getCommandByClass(name).make(param);
    }

    /**
     * Parses command
     *
     * @param cmd
     * @return
     * @throws Exception
     */
    public CommandData parseCommand(String cmd) throws Exception {
        //Format: <command-name>:<parameter-1> <parameter-2>
        String name = cmd.substring(0, cmd.indexOf(":"));
        List<String> params = Arrays.asList(cmd.substring(cmd.indexOf(":") + 1, cmd.length()).split(" "));
        return new CommandData(getCommandByName(name), params);
    }

    /**
     * gets command by class
     *
     * @param cls
     * @return
     * @throws Exception
     */
    public Command getCommandByClass(Class<?> cls) throws Exception {
        for (Map.Entry<String, Command> pair : commands.entrySet()) {
            if (pair.getValue().getClass().equals(cls)) {
                return pair.getValue();
            }
        }

        throw new Exception("No class found");
    }

    /**
     * gets command by name
     *
     * @param name
     * @return
     * @throws Exception
     */
    public Command getCommandByName(String name) throws Exception {
        Command cmd = commands.get(name);
        if (cmd == null) {
            throw new Exception("No command found");
        }

        return cmd;
    }

    private void loadDefaultCommands() {
        registerCommand(new TreeCommand());
    }

    private void registerCommand(Command cmd) {
        commands.put(cmd.getName(), cmd);
    }

}
