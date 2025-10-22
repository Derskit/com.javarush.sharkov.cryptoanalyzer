import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.stream.Stream;

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
        Path path = Path.of(filePath);
        if (!Validator.isDirectoryExists(BruteForce.directoryPath)){
            Files.createDirectory(Path.of(BruteForce.directoryPath));}
        if (Validator.isFileExists(filePath)){Files.delete(path);}
        Files.createFile(path);
        Files.write(path,content.getBytes(StandardCharsets.UTF_8));
    }
    public static void deleteFileWrite() throws IOException {
        Stream<Path> files = Files.walk(Path.of("C:\\Users\\Computer\\IdeaProjects\\cryptoanalyzer\\src\\bruteForceFiles"));
        files.sorted(Comparator.reverseOrder())
                .map(Path::toFile)
                .forEach(File::deleteOnExit);
        files.close();
        Files.delete(Path.of("C:\\Users\\Computer\\IdeaProjects\\cryptoanalyzer\\src\\text_write"));
    }
}
