package Library.commands;

import java.io.File;
import java.io.PrintWriter;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Viktoria Buchegger
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
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null) {
            return false;
        }

        if (getClass() != o.getClass()) {
            return false;
        }

        final CommandData other = (CommandData) o;
        if (!Objects.equals(this.command, other.command)) {
            return false;
        }

        if (!Objects.equals(this.parameter, other.parameter)) {
            return false;
        }

        return true;
    }

}
