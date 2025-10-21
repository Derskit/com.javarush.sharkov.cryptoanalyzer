import java.nio.file.Files;
import java.nio.file.Path;


public  class Validator {
    public static boolean isValidKey(int key, char[] alphabet) {
        // Проверка ключа
        if (key > 0){return true;}
        else {return false;}
    }
    public static boolean isFileExists(String filePath) {
        // Проверка существования файла
        Path path = Path.of(filePath);
        if(Files.exists(path) || Files.isRegularFile(path)){return true;}
        else {return false;}
    }
}