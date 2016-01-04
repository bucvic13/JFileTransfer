package commands;

import java.io.File;
import java.io.PrintWriter;
import java.util.List;
import java.util.Objects;

/**
 * Library
 *
 * @author Markus Petritz
 * @version 1.0.0
 */
public class CommandData {

    private final Command command;
    private final List<String> parameter;

    public CommandData(Command command, List<String> parameter) {
        this.command = command;
        this.parameter = parameter;
    }

    public void execute(File root, PrintWriter out) {
        command.execute(root, out);
    }

    public Command getCommand() {
        return command;
    }

    public List<String> getParameter() {
        return parameter;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.command);
        hash = 97 * hash + Objects.hashCode(this.parameter);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CommandData other = (CommandData) obj;
        if (!Objects.equals(this.command, other.command)) {
            return false;
        }
        if (!Objects.equals(this.parameter, other.parameter)) {
            return false;
        }
        return true;
    }
}
