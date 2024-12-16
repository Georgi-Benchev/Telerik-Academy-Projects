package recursionProblems.CodingTasks2;

import java.util.Scanner;

public class Task2_rewriteForPracticeDFS {
    private static int max = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();

        int[][] matrix = new int[x][y];

        for (int row = 0; row < x; row++) {
            for (int col = 0; col < y; col++) {
                matrix[row][col] = scanner.nextInt();
            }
            scanner.nextLine();
        }

        dfs(matrix);
        System.out.println(max);
    }

    public static void dfs(int[][] matrix) {
        boolean[][] validator = new boolean[matrix.length][matrix[0].length];


        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                validator[row][col] = true;
            }
        }

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if (validator[row][col]) {
                    int local = dfsHelper(matrix, validator, row, col);
                    if (local > max) {
                        max = local;
                    }
                }

            }
        }
    }

    public static int dfsHelper(int[][] matrix, boolean[][] validator, int row, int col) {
        validator[row][col] = false;
        int sum = 1;
        if (hasLeft(matrix, validator, row, col)) {

            sum += dfsHelper(matrix, validator, row, col - 1);
        }
        if (hasRight(matrix, validator, row, col)) {

            sum += dfsHelper(matrix, validator, row, col + 1);
        }
        if (hasUp(matrix, validator, row, col)) {

            sum += dfsHelper(matrix, validator, row - 1, col);
        }
        if (hasDown(matrix, validator, row, col)) {

            sum += dfsHelper(matrix, validator, row + 1, col);
        }
        return sum;
    }

    public static boolean hasLeft(int[][] matrix, boolean[][] validator, int row, int col) {
        return col > 0 && matrix[row][col - 1] == matrix[row][col] && validator[row][col - 1];
    }

    public static boolean hasRight(int[][] matrix, boolean[][] validator, int row, int col) {
        return col < matrix[0].length - 1 && matrix[row][col + 1] == matrix[row][col] && validator[row][col + 1];
    }

    public static boolean hasUp(int[][] matrix, boolean[][] validator, int row, int col) {
        return row > 0 && matrix[row - 1][col] == matrix[row][col] && validator[row - 1][col];
    }

    public static boolean hasDown(int[][] matrix, boolean[][] validator, int row, int col) {
        return row < matrix.length - 1 && matrix[row + 1][col] == matrix[row][col] && validator[row + 1][col];
    }
}
