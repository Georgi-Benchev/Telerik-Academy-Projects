package codingTasks.tasks_03_optimized;

import java.util.Scanner;

public class Task04_Bounce_basicSolution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = scanner.nextInt();
        int cols = scanner.nextInt();

        long sum = 0;
        boolean check = true;
        for (int row = 0; row < rows; row++) {
            if (check && row % 2 == 0) {
                for (int col = 0; col < cols; col++) {
                    sum += 1 + (3L * (row + col));
                    if (rows % 2 == 0 && col == cols - 1 && row == rows - 1) {
                        check = false;
                        break;
                    } else if (rows % 2 == 1 && col == 0 && row == rows - 1) {
                        check = false;
                        break;
                    }
                    if (col % 2 == 0) {
                        row++;
                    } else {
                        row--;
                    }
                }
            } else if (check) {
                for (int col = cols - 2; col >= 0; col--) {
                    if (rows % 2 == 0 && col == cols - 1 && row == rows - 1) {
                        check = false;
                        break;
                    } else if (rows % 2 == 1 && col == 0 && row == rows - 1) {
                        check = false;
                        break;
                    }
                    if (col % 2 == 0 && col != 0) {
                        row++;
                        sum += 1 + (3L * (row + col));
                    } else if (col != 0) {
                        row--;
                        sum += 1 + (3L * (row + col));
                    }
                }
            } else {
                break;
            }
        }
        System.out.println(sum);
    }
}