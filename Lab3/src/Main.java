import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();

        char[] alphabet = "АБВГҐДЕЄЖЗИІЇЙКЛМНОПРСТУФХЦЧШЩЬЮЯ".toCharArray();

        System.out.print("Введіть довжину рядка: ");
        int length = scanner.nextInt();

        System.out.print("Згенеровані індекси: ");

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int index = rand.nextInt(alphabet.length);
            System.out.print(index + " ");
            result.append(alphabet[index]);
        }

        System.out.println("\nЗгенерований рядок: " + result);
    }
}