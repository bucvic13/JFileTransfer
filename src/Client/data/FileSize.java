package Client.data;

import java.io.File;

/**
 *
 * @author Viktoria Buchegger
 */
public class FileSize {

    public FileSize() {
    }

    public static double calcFileSize(File file) {
        double kilobytes = 0.0;

        if (file.exists()) {
            kilobytes = ((file.length()) / 2014);
        }

        return kilobytes;
    }
}
