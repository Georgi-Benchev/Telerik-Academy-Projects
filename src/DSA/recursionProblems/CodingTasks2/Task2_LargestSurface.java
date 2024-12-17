package DSA.recursionProblems.CodingTasks2;

import java.util.Arrays;
import java.util.Scanner;

public class Task2_LargestSurface {

    private static final int[] dRow = {-1, 1, 0, 0};
    private static final int[] dCol = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfRows = scanner.nextInt();
        int numberOfCols = scanner.nextInt();
        scanner.nextLine();

        int[][] matrix = new int[numberOfRows][numberOfCols];
        for (int row = 0; row < numberOfRows; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int result = findLargestSurface(matrix);
        System.out.println(result);
    }

    /*

    5 6
    1 3 2 2 2 4
    3 3 3 2 4 4
    4 3 1 2 3 3
    4 3 1 3 3 1
    4 3 3 3 1 1

        */
    public static int findLargestSurface(int[][] matrix) {
        int matrixRows = matrix.length;
        int matrixCols = matrix[0].length;

        boolean[][] visited = new boolean[matrixRows][matrixCols];
        int largestSize = 0;

        // Loop through each cell in the matrix
        for (int row = 0; row < matrixRows; row++) {
            for (int col = 0; col < matrixCols; col++) {
                // If the cell is unvisited, perform DFS to find the connected region size
                if (!visited[row][col]) {
                    int regionSize = depthFirstSearch(matrix, visited, row, col, matrix[row][col]);
                    largestSize = Math.max(largestSize, regionSize);  // Update largestSize if needed
                }
            }
        }

        return largestSize;
    }

    private static int depthFirstSearch(int[][] matrix, boolean[][] visited, int row, int col, int value) {
        visited[row][col] = true;
        int size = 1;

        for (int i = 0; i < 4; i++) {
            int newRow = row + dRow[i];
            int newCol = col + dCol[i];

            if (newRow >= 0 && newRow < matrix.length && newCol >= 0 && newCol < matrix[0].length
                    && !visited[newRow][newCol] && matrix[newRow][newCol] == value) {

                size += depthFirstSearch(matrix, visited, newRow, newCol, value);
            }
        }
        return size;
    }
}