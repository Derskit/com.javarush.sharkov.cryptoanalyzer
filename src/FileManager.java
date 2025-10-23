import constants.AppConstants;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.charset.StandardCharsets;
import java.util.Comparator;
import java.util.stream.Stream;

public class FileManager {
    public static String readFile(String filePath) throws IOException {
        if (Validator.isFileExists(filePath)) {
            Path path = Path.of(filePath);
            byte[] bytes = Files.readAllBytes(path);

            return new String(bytes, StandardCharsets.UTF_8);
        } else return "";
    }
    public static void writeFile(String content, String filePath) throws IOException {
        Path path = Path.of(filePath);

        if (!Validator.isDirectoryExists(BruteForce.directoryPath)) {
            Files.createDirectory(Path.of(BruteForce.directoryPath));
        }
        if (Validator.isFileExists(filePath)) {
            Files.delete(path);
        }
        Files.createFile(path);
        Files.write(path, content.getBytes(StandardCharsets.UTF_8));
    }
    public static void deleteFileWrite() throws IOException {
        if (Files.isDirectory(Path.of(BruteForce.directoryPath))) {
            Stream<Path> files = Files.walk(Path.of(BruteForce.directoryPath));
            files.sorted(Comparator.reverseOrder())
                    .map(Path::toFile)
                    .forEach(File::deleteOnExit);
            files.close();
        }
        Files.deleteIfExists(Path.of(AppConstants.PATH_WRITE));
    }
}
