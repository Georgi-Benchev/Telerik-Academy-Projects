package codingTasks.tasks_02;

import java.util.Arrays;
import java.util.Scanner;

public class Task04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] parameters = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int rows = parameters[0];
        int cols = parameters[1];

        long[][] matrix = new long[rows][cols];
        long sum = 0;
        fillingTheMatrix(rows, cols, matrix);


        String diagonalDirection = "RightDown";

        int currentRow = 0;
        int currentCol = 0;

        while (Math.min(rows, cols) > 1) {

            if (diagonalDirection.equals("RightDown")) {
                if (currentRow < rows - 1 && currentCol < cols - 1) {
                    sum = getSum(sum, currentCol, matrix[currentRow]);
                    currentRow++;
                    currentCol++;
                } else if (currentRow == rows - 1 && currentCol < cols - 1) {
                    sum = getSum(sum, currentCol, matrix[currentRow]);
                    currentRow--;
                    currentCol++;
                    diagonalDirection = "RightUp";
                } else if (currentRow < rows - 1 && currentCol == cols - 1) {
                    sum = getSum(sum, currentCol, matrix[currentRow]);
                    currentRow++;
                    currentCol--;
                    diagonalDirection = "LeftDown";
                }


            } else if (diagonalDirection.equals("RightUp")) {
                if (currentRow > 0 && currentCol < cols - 1) {
                    sum = getSum(sum, currentCol, matrix[currentRow]);
                    currentRow--;
                    currentCol++;
                } else if (currentRow == 0 && currentCol < cols - 1) {
                    sum = getSum(sum, currentCol, matrix[currentRow]);
                    currentRow++;
                    currentCol++;
                    diagonalDirection = "RightDown";
                } else if (currentRow > 0 && currentCol == cols - 1) {
                    sum = getSum(sum, currentCol, matrix[currentRow]);
                    currentRow--;
                    currentCol--;
                    diagonalDirection = "LeftUp";
                }
            } else if (diagonalDirection.equals("LeftDown")) {
                if (currentRow < rows - 1 && currentCol > 0) {
                    sum = getSum(sum, currentCol, matrix[currentRow]);
                    currentRow++;
                    currentCol--;
                } else if (currentRow == rows - 1 && currentCol > 0) {
                    sum = getSum(sum, currentCol, matrix[currentRow]);
                    currentRow--;
                    currentCol--;
                    diagonalDirection = "LeftUp";
                } else if (currentRow < rows - 1 && currentCol == 0) {
                    sum = getSum(sum, currentCol, matrix[currentRow]);
                    currentRow++;
                    currentCol++;
                    diagonalDirection = "RightDown";
                }
            } else if (diagonalDirection.equals("LeftUp")) {
                if (currentRow > 0 && currentCol > 0) {
                    sum = getSum(sum, currentCol, matrix[currentRow]);
                    currentRow--;
                    currentCol--;
                } else if (currentRow == 0 && currentCol > 0) {
                    sum = getSum(sum, currentCol, matrix[currentRow]);
                    currentRow++;
                    currentCol--;
                    diagonalDirection = "LeftDown";
                } else if (currentRow > 0 && currentCol == 0) {
                    sum = getSum(sum, currentCol, matrix[currentRow]);
                    currentRow--;
                    currentCol++;
                    diagonalDirection = "RightUp";
                }
            }

            if ((currentRow == 0 && currentCol == 0)
                    || (currentRow == 0 && currentCol == cols - 1)
                    || (currentRow == rows - 1 && currentCol == 0)
                    || (currentRow == rows - 1 && currentCol == cols - 1)) {
                break;
            }
        }
        sum = getSum(sum, currentCol, matrix[currentRow]);

        System.out.println(sum);
    }

    private static long getSum(long sum, int currentCol, long[] matrix) {
        sum += matrix[currentCol];
        return sum;
    }

    private static void fillingTheMatrix(int rows, int cols, long[][] matrix) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = (long) Math.pow(2, row + col);
            }
        }
    }
}