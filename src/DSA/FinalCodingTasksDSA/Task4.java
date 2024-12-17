package DSA.FinalCodingTasksDSA;

import java.util.*;

public class Task4 {
    public static int sum = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int x = scanner.nextInt();
        int y = scanner.nextInt();
        scanner.nextLine();
        boolean[][] matrix = new boolean[x][y];

        for (int row = 0; row < x; row++) {
            char[] line = scanner.nextLine().toCharArray();
            for (int col = 0; col < y; col++) {
                matrix[row][col] = line[col] == '1';
            }
        }

        PriorityQueue<Integer> results = new PriorityQueue<>(Comparator.reverseOrder());
        for (int row = 0; row < x; row++) {
            for (int col = 0; col < y; col++) {
                if (matrix[row][col]) {
                    sum = 0;
                    dfsHelper(matrix, row, col);
                    results.add(sum);
                }
            }
        }

        int size = results.size();
        for (int i = 0; i < size; i++) {
            System.out.println(results.poll());
        }

    }


    public static void dfsHelper(boolean[][] matrix, int row, int col) {
        matrix[row][col] = false;
        sum++;
        if (col > 0 && matrix[row][col - 1]) {

            dfsHelper(matrix, row, col - 1);
        }
        if (col < matrix[0].length - 1 && matrix[row][col + 1]) {

            dfsHelper(matrix, row, col + 1);
        }
        if (row > 0 && matrix[row - 1][col]) {

            dfsHelper(matrix, row - 1, col);
        }
        if (row < matrix.length - 1 && matrix[row + 1][col]) {

            dfsHelper(matrix, row + 1, col);
        }
    }
}


