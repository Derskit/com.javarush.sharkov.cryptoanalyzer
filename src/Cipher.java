import java.io.IOException;
import java.util.Arrays;

public class Cipher {

    protected static final char[] ALPHABET = {' ', '!', '"', '\'', ',', '.', ':', '?',
            '«', '»', 'а', 'б', 'в', 'г', 'д', 'е', 'ж', 'з', 'и',
            'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у',
            'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'ю',
            'я', 'ё'};

    public static String encrypt(String text, int shift) throws IOException {
        if (Validator.isValidKey(shift, ALPHABET)){
            if (shift > ALPHABET.length){shift = shift % ALPHABET.length;}
            char[] text_in = FileManager.readFile(text).toLowerCase().toCharArray();
            int index = 0;
            for (int i = 0; i < text_in.length; i++){
                index = Arrays.binarySearch(ALPHABET, text_in[i]);
                if (index < 0){continue;}
                if (ALPHABET.length > index + shift){text_in[i] = ALPHABET[index+shift];}
                else {text_in[i] = ALPHABET[(index + shift) - ALPHABET.length];}
            }
            return new String(text_in);
        }
        return "";
    }
    public static String decrypt(String encryptedText, int shift) throws IOException {
        // Логика расшифровки
        if (Validator.isValidKey(shift, ALPHABET)){
            if (shift > ALPHABET.length){shift = shift % ALPHABET.length;}
            char[] text_in = FileManager.readFile(encryptedText).toLowerCase().toCharArray();
            int index = 0;
            for (int i = 0; i < text_in.length; i++){
                index = Arrays.binarySearch(ALPHABET, text_in[i]);
                if (index < 0){continue;}
                if (0 <= index - shift && ALPHABET.length > index - shift){text_in[i] = ALPHABET[index - shift];}
                else {text_in[i] = ALPHABET[(index - shift) + ALPHABET.length-1];}
            }
            return new String(text_in);
        }
        return "";
    }
}
