package DSA.recursionProblems.CodingTasks2;

import java.util.Arrays;
import java.util.Scanner;

public class Task1_ScroogeMcDuck {

    static int totalCoins = 0;
    static int staticRow = -1;
    static int staticCol = -1;
    static int[][] staticMatrix;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] staticMatrixSize = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int rows = staticMatrixSize[0];
        int cols = staticMatrixSize[1];
        staticMatrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            int[] staticMatrixRow = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            if (staticRow == -1) {
                for (int col = 0; col < cols; col++) {
                    if (staticMatrixRow[col] == 0) {
                        staticRow = row;
                        staticCol = col;
                        break;
                    }
                }
            }
            staticMatrix[row] = staticMatrixRow;
        }
        findCoinsCount();




    }



    private static void findCoinsCount() {
        boolean check = true;
        int leftIndex = 0;
        int rightIndex = 0;
        int upIndex = 0;
        int downIndex = 0;

        if (staticCol != 0) {
            leftIndex = staticMatrix[staticRow][staticCol - 1];
        }

        if (staticCol != staticMatrix[0].length - 1) {
            rightIndex = staticMatrix[staticRow][staticCol + 1];
        }

        if (staticRow != 0) {
            upIndex = staticMatrix[staticRow - 1][staticCol];
        }

        if (staticRow != staticMatrix.length - 1) {
            downIndex = staticMatrix[staticRow + 1][staticCol];
        }


        if (leftIndex >= rightIndex && leftIndex >= upIndex && leftIndex >= downIndex) {
            if (leftIndex != 0) {
                staticCol--;
            }else {
                check=false;
            }
        } else if (rightIndex > leftIndex && rightIndex >= upIndex && rightIndex >= downIndex) {
            if (rightIndex != 0) {
                staticCol++;
            }else {
                check=false;
            }
        } else if (upIndex > leftIndex && upIndex > rightIndex && upIndex >= downIndex) {
            if (upIndex != 0) {
                staticRow--;
            }else {
                check=false;
            }
        } else if (downIndex > leftIndex && downIndex > rightIndex && downIndex > upIndex){
            if (downIndex != 0) {
                staticRow++;
            }else {
                check=false;
            }
        }else {
            check=false;
        }
        if (check){
            staticMatrix[staticRow][staticCol]--;
            totalCoins++;
            findCoinsCount();
        }else {
            System.out.println(totalCoins);
        }
    }


}

