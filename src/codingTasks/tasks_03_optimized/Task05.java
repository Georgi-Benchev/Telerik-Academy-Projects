package codingTasks.tasks_03_optimized;

import java.util.Scanner;

public class Task05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[][] matrix = new int[n][n];

        int rounds = 0;
        int direction = 0;
        int rounds2 = 0;
        int newCount = 0;

        for (int count = 1; count <= n * n; count++) {
            if (direction == 0) {
                matrix[rounds][rounds + newCount] = count;
            } else if (direction == 1) {
                matrix[rounds + newCount][n - 1 - rounds] = count;
            } else if (direction == 2) {
                matrix[n - 1 - rounds][n - 1 - rounds - newCount] = count;
            } else if (direction == 3) {
                matrix[n - 1 - rounds - newCount][rounds] = count;
            }

            newCount++;
            if (n-1-rounds2==newCount) {
                direction++;
                newCount = 0;
            }
            if (direction == 4) {
                rounds2+=2;
                rounds++;
                direction = 0;
            }
        }

        for (int[] array : matrix) {
            for (int digit : array) {
                System.out.print(digit + " ");
            }
            System.out.println();
        }
    }
}