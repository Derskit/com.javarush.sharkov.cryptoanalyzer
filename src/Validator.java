import java.nio.file.Files;
import java.nio.file.Path;


public  class Validator {
    public boolean isValidKey(int key, char[] alphabet) {
        // Проверка ключа
        return false;
    }
    public static boolean isFileExists(String filePath) {
        // Проверка существования файла
        Path path = Path.of(filePath);
        if(Files.exists(path)){
                return true;
        }else {
        return false;}
    }
}