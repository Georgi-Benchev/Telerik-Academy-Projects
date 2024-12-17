package DSA.FinalCodingTasksDSA;

import java.util.*;

public class Task4_vol2 {
    private static int sum;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        scanner.nextLine();
        char[][] matrix = new char[rows][cols];
        PriorityQueue<Integer> outputs = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i = 0; i < rows; i++) {
            matrix[i] = scanner.nextLine().toCharArray();
        }

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (matrix[row][col] == '1') {
                    sum = 0;
                    dfsHelper(matrix, row, col);
                    outputs.add(sum);
                }
            }
        }

        int size = outputs.size();
        for (int i = 0; i < size; i++) {
            System.out.println(outputs.poll());
        }
    }

    public static void dfsHelper(char[][] matrix, int row, int col) {
        matrix[row][col] = '0';
        sum++;
        if (col > 0 && matrix[row][col - 1] == '1') {

            dfsHelper(matrix, row, col - 1);
        }
        if (col < matrix[0].length - 1 && matrix[row][col + 1] == '1') {

            dfsHelper(matrix, row, col + 1);
        }
        if (row > 0 && matrix[row - 1][col] == '1') {

            dfsHelper(matrix, row - 1, col);
        }
        if (row < matrix.length - 1 && matrix[row + 1][col] == '1') {

            dfsHelper(matrix, row + 1, col);
        }
    }
}
