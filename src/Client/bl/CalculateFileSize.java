package Client.bl;

import java.io.File;

/**
 *
 * @author Viktoria Buchegger
 */
public class CalculateFileSize {

    public CalculateFileSize() {
    }

    //calculates the size of the File and returns it in kilobytes
    public static double calcFileSize(File file) {
        double kilobytes = 0.0;

        if (file.exists()) {
            double bytes = file.length();
            kilobytes = (bytes / 1014);
        }

        return kilobytes;
    }
}
