import java.io.IOException;

public class Cipher {

    public static String encrypt(String text, int shift) throws IOException {
        // Логика шифрования
        char[] text_in = FileManager.readFile(text).toLowerCase().toCharArray();
        int count;
        for (int i = 0; i < text_in.length; i++){
            count = 0;
            int index = 0;
            for (char ch: MainApp.ALPHABET){
                if (ch == text_in[i]){
                    index = count;
                    break;
                }
                count++;
            }
            if (MainApp.ALPHABET.length-1 >= index + shift){
                text_in[i] = MainApp.ALPHABET[index+shift];
            }
            else {
                text_in[i] = MainApp.ALPHABET[(index + shift) % MainApp.ALPHABET.length-1];
            }
        }

        return new String(text_in);
    }
    public static String decrypt(String encryptedText, int shift) {
        // Логика расшифровки
        return null;
    }
}
