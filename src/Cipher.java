import java.io.IOException;
import java.util.Arrays;

public class Cipher {

    public static String encrypt(String text, int shift) throws IOException {
        // Логика шифрования
        char[] text_in = FileManager.readFile(text).toLowerCase().toCharArray();
        int index = 0;

        for (int i = 0; i < text_in.length; i++){
            index = Arrays.binarySearch(MainApp.ALPHABET, text_in[i]);
            if (MainApp.ALPHABET.length-1 >= index + shift){
                text_in[i] = MainApp.ALPHABET[index+shift];
            }
            else {
                text_in[i] = MainApp.ALPHABET[(index + shift) - MainApp.ALPHABET.length];
            }
        }

        return new String(text_in);
    }
    public static String decrypt(String encryptedText, int shift) {
        // Логика расшифровки
        return null;
    }
}
