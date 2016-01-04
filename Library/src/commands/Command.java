package commands;

import java.io.File;
import java.io.PrintWriter;
import java.util.List;
import java.util.Objects;

public abstract class Command {
    
    private final String name;

    public Command(String name) {
        this.name = name;
    }
    
    public abstract void execute(File root, PrintWriter out);
    
    public String make(List<String> parameter) {
        StringBuilder params = new StringBuilder();
        for (String pa : parameter) {
            params.append(pa).append(" ");
        }
        String paramStr = params.toString().substring(0, params.length() - 1);
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
        final Command other = (Command) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }
}
