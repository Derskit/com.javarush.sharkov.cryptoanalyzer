
import java.io.IOException;
import java.util.Scanner;

public class MainApp {
    public static final char[] ALPHABET = {'а', 'б', 'в', 'г', 'д', 'е', 'ж', 'з',
            'и','к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ',
            'ъ', 'ы', 'ь', 'э', 'я', '.', ',', '«', '»', '"', '\'', ':', '!', '?', ' '};
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        byte mode;
        boolean isExit = false;
        while (!isExit){
            System.out.println("// Логика меню\n" +
                    "    // 1. Шифрование\n" +
                    "    // 2. Расшифровка с ключом\n" +
                    "    // 3. Brute force\n" +
                    "    // 4. Статистический анализ\n" +
                    "    // 0. Выход");
            mode = scanner.nextByte();
            switch (mode){
                case 1 -> {
                    String text = Cipher.encrypt("C:\\Users\\Computer\\javarush\\3611105\\javarush-project\\src\\com\\javarush\\task\\jdk13\\task53\\task5307\\test_text", scanner.nextInt());
                    FileManager.writeFile(text, "C:\\Users\\Computer\\javarush\\3611105\\javarush-project\\src\\com\\javarush\\task\\jdk13\\task53\\task5307\\tetetet.txt");
                    System.out.println(text);
                }
                case 2 -> Cipher.decrypt("test_text.txt", scanner.nextByte());
                case 3 -> BruteForce.decryptByBruteForce("test_text.txt", ALPHABET);
                case 4 -> StatisticalAnalyzer.findMostLikelyShift("test_text.txt", ALPHABET, "zxc");
                default -> isExit = true;
            }
        }
    }
}