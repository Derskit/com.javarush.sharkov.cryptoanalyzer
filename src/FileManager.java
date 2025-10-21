import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.charset.StandardCharsets;

public class FileManager {
    public static String readFile(String filePath) throws IOException {
        // Логика чтения файла
        if (Validator.isFileExists(filePath)){Path path = Path.of(filePath);
            byte[] bytes = Files.readAllBytes(path);
            return new String(bytes, StandardCharsets.UTF_8);}
        else return "";
    }
    public static void writeFile(String content, String filePath) throws IOException {
        // Логика записи файла
        if (Validator.isFileExists(filePath)){
            Path path = Path.of(filePath);
            Files.write(path,content.getBytes(StandardCharsets.UTF_8));
        }

    }
}
