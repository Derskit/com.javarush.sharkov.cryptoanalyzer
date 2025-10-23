import java.nio.file.Files;
import java.nio.file.Path;

public class Validator {
    public static boolean isValidKey(int key) {
        if (key > 0) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isFileExists(String filePath) {
        Path path = Path.of(filePath);
        if (Files.exists(path) && Files.isRegularFile(path)) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isDirectoryExists(String filePath) {
        Path path = Path.of(filePath);
        if (Files.exists(path) && Files.isDirectory(path)) {
            return true;
        } else {
            return false;
        }
    }
}