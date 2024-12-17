package DSA.recursionProblems.CodingTasks2;

import java.util.Scanner;

public class Task1_rewriteForPracticeDFS {
    private static int sum = -1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int[][] matrix = new int[x][y];

        int rowZero = 0;
        int colZero = 0;
        for (int row = 0; row < x; row++) {
            for (int col = 0; col < y; col++) {
                matrix[row][col] = scanner.nextInt();
                if (matrix[row][col] == 0) {
                    rowZero = row;
                    colZero = col;
                }
            }
        }

        gatherCoins(matrix, rowZero, colZero);
        System.out.println(sum);
    }

    private static void gatherCoins(int[][] matrix, int row, int col) {
        sum++;
        matrix[row][col]--;
        if (shouldGoLeft(matrix, row, col)) {
            gatherCoins(matrix, row, col - 1);
        } else if (shouldGoRight(matrix, row, col)) {
            gatherCoins(matrix, row, col + 1);
        } else if (shouldGoUp(matrix, row, col)) {
            gatherCoins(matrix, row - 1, col);
        } else if (shouldGoDown(matrix, row, col)) {
            gatherCoins(matrix, row + 1, col);
        }
    }

    private static boolean shouldGoLeft(int[][] matrix, int row, int col) {
        int valueLeft;
        int valueRight = 0;
        int valueUp = 0;
        int valueDown = 0;

        if (canGoLeft(col)) {
            valueLeft = matrix[row][col - 1];
        } else {
            return false;
        }

        if (canGoRight(col, matrix[0].length)) {
            valueRight = matrix[row][col + 1];
        }
        if (canGoUp(row)) {
            valueUp = matrix[row - 1][col];
        }
        if (canGoDown(row, matrix.length)) {
            valueDown = matrix[row + 1][col];
        }

        return valueLeft >= valueRight && valueLeft >= valueUp && valueLeft >= valueDown && valueLeft > 0;
    }

    private static boolean shouldGoRight(int[][] matrix, int row, int col) {
        int valueRight;
        int valueLeft = 0;
        int valueUp = 0;
        int valueDown = 0;

        if (canGoRight(col, matrix[0].length)) {
            valueRight = matrix[row][col + 1];
        } else {
            return false;
        }

        if (canGoLeft(col)) {
            valueLeft = matrix[row][col - 1];
        }
        if (canGoUp(row)) {
            valueUp = matrix[row - 1][col];
        }
        if (canGoDown(row, matrix.length)) {
            valueDown = matrix[row + 1][col];
        }

        return valueLeft < valueRight && valueRight >= valueUp && valueRight >= valueDown && valueRight > 0;
    }

    private static boolean shouldGoUp(int[][] matrix, int row, int col) {
        int valueUp;
        int valueLeft = 0;
        int valueRight = 0;
        int valueDown = 0;

        if (canGoUp(row)) {
            valueUp = matrix[row - 1][col];
        } else {
            return false;
        }

        if (canGoLeft(col)) {
            valueLeft = matrix[row][col - 1];
        }
        if (canGoRight(col, matrix[0].length)) {
            valueRight = matrix[row][col + 1];
        }
        if (canGoDown(row, matrix.length)) {
            valueDown = matrix[row + 1][col];
        }

        return valueUp > valueLeft && valueUp > valueRight && valueUp >= valueDown && valueUp > 0;
    }

    private static boolean shouldGoDown(int[][] matrix, int row, int col) {
        int valueDown;
        int valueLeft = 0;
        int valueRight = 0;
        int valueUp = 0;

        if (canGoDown(row, matrix.length)) {
            valueDown = matrix[row + 1][col];
        } else {
            return false;
        }

        if (canGoLeft(col)) {
            valueLeft = matrix[row][col - 1];
        }
        if (canGoRight(col, matrix[0].length)) {
            valueRight = matrix[row][col + 1];
        }
        if (canGoUp(row)) {
            valueUp = matrix[row - 1][col];
        }

        return valueDown > valueLeft && valueDown > valueRight && valueDown > valueUp && valueDown > 0;
    }


    private static boolean canGoLeft(int col) {
        return col > 0;
    }

    private static boolean canGoRight(int col, int maxCol) {
        return col < maxCol - 1;
    }

    private static boolean canGoUp(int row) {
        return row > 0;
    }

    private static boolean canGoDown(int row, int maxRow) {
        return row < maxRow - 1;
    }
}
