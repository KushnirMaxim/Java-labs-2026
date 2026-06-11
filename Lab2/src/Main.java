import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть кількість рядків: ");
        int rows = scanner.nextInt();

        System.out.print("Введіть кількість стовпців: ");
        int cols = scanner.nextInt();

        Random rand = new Random();

        double[][] MB = new double[rows][cols];
        double[][] MC = new double[rows][cols];
        double[][] MD = new double[rows][cols];
        double[][] MA = new double[rows][cols];

        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++) {
                MB[i][j] = rand.nextDouble();
                MC[i][j] = rand.nextDouble();
                MD[i][j] = rand.nextDouble();
            }

        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                MA[i][j] = MB[i][j] - MC[i][j] + MD[i][j];

        printMatrix("MB", MB);
        printMatrix("MC", MC);
        printMatrix("MD", MD);
        printMatrix("MA = MB - MC + MD", MA);
    }

    static void printMatrix(String name, double[][] m) {
        System.out.println("\n" + name + ":");
        for (double[] row : m) {
            for (double val : row)
                System.out.printf("%.4f ", val);
            System.out.println();
        }
    }
}