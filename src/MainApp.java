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
                    //"4. Статистический анализ\n" +
                    //"5. Удаление файлов записи\n" +
                    "0. Выход");
            mode = scanner.nextByte();
            switch (mode) {
                case 1 -> {
                    scanner.nextLine(); // Очистка буфера
                    System.out.print("Ввдение путь файла чтения: ");
                    String path_read = scanner.nextLine();
                    System.out.println();
                    System.out.print("Введите ключ: ");
                    String text = Cipher.encrypt(path_read, scanner.nextInt());
                    scanner.nextLine(); // Очистка буфера
                    System.out.print("Ввдение путь файла записи: ");
                    String path_write = scanner.nextLine();
                    FileManager.writeFile(text, path_write);
                    System.out.println(text);
                }
                case 2 -> {
                    scanner.nextLine(); // Очистка буфера
                    System.out.print("Ввдение путь файла чтения: ");
                    String path_read = scanner.nextLine();
                    System.out.print("Введите ключ: ");
                    String text = Cipher.decrypt(path_read, scanner.nextInt());
                    scanner.nextLine(); // Очистка буфера
                    System.out.print("Ввдение путь файла записи: ");
                    String path_write = scanner.nextLine();
                    FileManager.writeFile(text, path_write);
                    System.out.println(text);
                }
                case 3 -> {
                    scanner.nextLine(); // Очистка буфера
                    System.out.print("Ввдение путь файла чтения: ");
                    String path_read = scanner.nextLine();
                    System.out.print("Ввдение путь дериктории записи: ");
                    BruteForce.directoryPath = scanner.nextLine();
                    BruteForce.decryptByBruteForce(path_read);
                }
                //case 4 -> StatisticalAnalyzer.findMostLikelyShift("test_text.txt", Cipher.ALPHABET, "zxc");
                //case 5 -> FileManager.deleteFileWrite();
                default -> isExit = true;
            }
        }
    }
}