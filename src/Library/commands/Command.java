package Library.commands;

import java.io.File;
import java.io.PrintWriter;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Viktoria Buchegger
 */
public abstract class Command {

    private final String name;

    public Command(String name) {
        this.name = name;
    }

    public abstract void execute(File root, PrintWriter out);

    public String make(List<String> parameter) {
        String paramStr = "";

        if (parameter != null) {
            StringBuilder params = new StringBuilder();
            for (String p : parameter) {
                params.append(p).append(" ");
            }

            paramStr = params.toString().substring(0, params.length() - 1);
        }

        return String.format("%s:%s", name, paramStr);
    }

    public String getName() {
        return name;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.name);
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

        final Command other = (Command) o;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }

        return true;
    }

}
