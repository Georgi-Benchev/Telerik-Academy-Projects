package codingTasks.tasks_03_optimized;

import java.util.Scanner;

public class Task04_Bounce_hackedWithScanner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        short rows = scanner.nextShort();
        short cols = scanner.nextShort();

        long sum = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if ((row + col) % 2 == 0) {
                    sum += 1 + (3 * (row + col));
                }
                if ((col % 2 == 1 && row % 2 == 1 && row != rows - 1 && col != cols - 1)
                        || (col % 2 == 0 && row % 2 == 0 && row != rows - 1 && row != 0 && col != 0 && col != cols - 1)) {
                    sum += 1 + (3 * (row + col));
                }
            }
        }

        System.out.println(sum);
    }
}