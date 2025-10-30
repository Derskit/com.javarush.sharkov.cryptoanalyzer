import java.io.IOException;

public class BruteForce {
    protected static String directoryPath = "";

    public static void decryptByBruteForce(String encryptedText) throws IOException {
        String text;
        directoryPath += "\\bruteForceSave";
        System.out.println(directoryPath);
        for (int i = 1; i <= Cipher.ALPHABET.length; i++) {
            text = Cipher.decrypt(encryptedText, i);
            FileManager.writeFile(text, directoryPath + "\\text_" + i);
        }
    }
}
