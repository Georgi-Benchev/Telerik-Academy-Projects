package codingTasks.tasks_01;

import java.util.Scanner;

public class Task04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[][] chesBoard = new int[n][n];

        int count = 1;
        int cordinatesRow = 0;
        int cordinatesCol = 0;

        while (count <= n * n) {
            if (chesBoard[cordinatesRow][cordinatesCol] == 0) {
                chesBoard[cordinatesRow][cordinatesCol] = count;
            }

            if (cordinatesRow - 2 >= 0 && cordinatesCol - 1 >= 0 && chesBoard[cordinatesRow - 2][cordinatesCol - 1] == 0) {
                cordinatesRow -= 2;
                cordinatesCol -= 1;
            } else if (cordinatesRow - 2 >= 0 && cordinatesCol + 1 < n && chesBoard[cordinatesRow - 2][cordinatesCol + 1] == 0) {
                cordinatesRow -= 2;
                cordinatesCol += 1;
            } else if (cordinatesRow - 1 >= 0 && cordinatesCol - 2 >= 0 && chesBoard[cordinatesRow - 1][cordinatesCol - 2] == 0) {
                cordinatesRow -= 1;
                cordinatesCol -= 2;
            } else if (cordinatesRow - 1 >= 0 && cordinatesCol + 2 < n && chesBoard[cordinatesRow - 1][cordinatesCol + 2] == 0) {
                cordinatesRow -= 1;
                cordinatesCol += 2;
            } else if (cordinatesRow + 1 < n && cordinatesCol - 2 >= 0 && chesBoard[cordinatesRow + 1][cordinatesCol - 2] == 0) {
                cordinatesRow += 1;
                cordinatesCol -= 2;
            } else if (cordinatesRow + 1 < n && cordinatesCol + 2 < n && chesBoard[cordinatesRow + 1][cordinatesCol + 2] == 0) {
                cordinatesRow += 1;
                cordinatesCol += 2;
            } else if (cordinatesRow + 2 < n && cordinatesCol - 1 >= 0 && chesBoard[cordinatesRow + 2][cordinatesCol - 1] == 0) {
                cordinatesRow += 2;
                cordinatesCol -= 1;
            } else if (cordinatesRow + 2 < n && cordinatesCol + 1 < n && chesBoard[cordinatesRow + 2][cordinatesCol + 1] == 0) {
                cordinatesRow += 2;
                cordinatesCol += 1;
            } else {
                boolean check = true;
                for (int row = 0; row < n && check; row++) {
                    for (int col = 0; col < n; col++) {
                        if (chesBoard[row][col] == 0) {
                            cordinatesRow = row;
                            cordinatesCol = col;
                            check = false;
                            break;
                        }
                    }
                }
            }

            count++;
        }

        for (int[] line : chesBoard) {
            for (int num : line) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}