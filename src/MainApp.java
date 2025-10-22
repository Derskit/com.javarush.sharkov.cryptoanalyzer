
import java.io.IOException;
import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        byte mode;
        boolean isExit = false;
        while (!isExit){
            System.out.println("    // 1. Шифрование\n" +
                    "    // 2. Расшифровка с ключом\n" +
                    "    // 3. Brute force\n" +
                    "    // 4. Статистический анализ\n" +
                    "    // 0. Выход");
            mode = scanner.nextByte();
            switch (mode){
                case 1 -> {
                    String text = Cipher.encrypt("C:\\Users\\Computer\\IdeaProjects\\cryptoanalyzer\\src\\text_read", scanner.nextInt());
                    FileManager.writeFile(text, "C:\\Users\\Computer\\IdeaProjects\\cryptoanalyzer\\src\\text_write");
                    System.out.println(text);
                }
                case 2 -> {
                    String text = Cipher.decrypt("C:\\Users\\Computer\\IdeaProjects\\cryptoanalyzer\\src\\text_read", scanner.nextInt());
                    FileManager.writeFile(text, "C:\\Users\\Computer\\IdeaProjects\\cryptoanalyzer\\src\\text_write");
                    System.out.println(text);
                }
                case 3 -> BruteForce.decryptByBruteForce("C:\\Users\\Computer\\IdeaProjects\\cryptoanalyzer\\src\\text_read");
                case 4 -> StatisticalAnalyzer.findMostLikelyShift("test_text.txt", Cipher.ALPHABET, "zxc");
                default -> isExit = true;
            }
        }
    }
}