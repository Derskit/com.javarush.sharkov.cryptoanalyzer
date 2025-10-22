import java.io.IOException;

public class BruteForce {
    public static void decryptByBruteForce(String encryptedText) throws IOException {
        String text;
        for(int i = 1; i < Cipher.ALPHABET.length; i++){
            text = Cipher.decrypt(encryptedText, i);
            FileManager.writeFile(text, "C:\\Users\\Computer\\IdeaProjects\\cryptoanalyzer\\src\\bruteForceFiles\\text_" + i);
        }
    }
}
