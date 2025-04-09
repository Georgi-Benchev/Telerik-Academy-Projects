package codingTasks.tasks_03_optimized;

import java.util.Arrays;
import java.util.Scanner;

public class Task03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[n][];
        fillingMatrix(n, matrix, scanner);
        String[] coordinates = scanner.nextLine().split(" ");
        int bestSum = Integer.MIN_VALUE;

        for (int i = 0; i < coordinates.length; i += 2) {
            int rowTarget = Math.abs(Integer.parseInt(coordinates[i])) - 1;
            int colTarget = Math.abs(Integer.parseInt(coordinates[i + 1])) - 1;

            int sum = 0;
            // horizontal logic
            if (coordinates[i].charAt(0) == '-') {   // case "-"
                for (int col = matrix[rowTarget].length - 1; col >= colTarget; col--) {
                    sum += matrix[rowTarget][col];
                }
            } else {        // case "+"
                for (int col = 0; col <= colTarget; col++) {
                    sum += matrix[rowTarget][col];
                }
            }

            // vertical logic
            if (coordinates[i + 1].charAt(0) == '-') {   // case "-"
                for (int row = rowTarget + 1; row <= n - 1; row++) {
                    sum += matrix[row][colTarget];
                }
            } else {        //case +
                for (int row = 0; row < rowTarget; row++) {
                    sum += matrix[row][colTarget];
                }
            }

            if (sum >= bestSum) {
                bestSum = sum;
            }
        }
        System.out.println(bestSum);
    }

    private static void fillingMatrix(int n, int[][] matrix, Scanner scanner) {
        for (int i = 0; i < n; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
    }
}
/*  best test cases for checking all 4 corners "1" "6" "9" "4"  --> output should be 9
6
1 2 3 4 5 6
2 3 4 5 6 7
6 5 4 3 2 1
3 4 5 6 7 8
4 5 6 7 8 9
9 8 7 6 5 4
-6 -6 -1 6 1 1 6 -1
*/
