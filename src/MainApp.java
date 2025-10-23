import constants.AppConstants;

import java.io.IOException;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        byte mode;
        boolean isExit = false;

        while (!isExit) {
            System.out.println("1. Шифрование\n" +
                    "2. Расшифровка с ключом\n" +
                    "3. Brute force\n" +
                    "4. Статистический анализ\n" +
                    "5. Удаление файлов записи\n" +
                    "0. Выход");
            mode = scanner.nextByte();
            switch (mode) {
                case 1 -> {
                    System.out.print("Введите ключ: ");
                    String text = Cipher.encrypt(AppConstants.PATH_READ, scanner.nextInt());
                    FileManager.writeFile(text, AppConstants.PATH_WRITE);
                    System.out.println(text);
                }
                case 2 -> {
                    System.out.print("Введите ключ: ");
                    String text = Cipher.decrypt(AppConstants.PATH_READ, scanner.nextInt());
                    FileManager.writeFile(text, AppConstants.PATH_WRITE);
                    System.out.println(text);
                }
                case 3 ->
                        BruteForce.decryptByBruteForce(AppConstants.PATH_READ);
                case 4 -> StatisticalAnalyzer.findMostLikelyShift("test_text.txt", Cipher.ALPHABET, "zxc");
                case 5 -> FileManager.deleteFileWrite();
                default -> isExit = true;
            }
        }
    }
}