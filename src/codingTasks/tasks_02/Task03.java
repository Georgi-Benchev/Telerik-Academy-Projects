package codingTasks.tasks_02;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class Task03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rowSize = Integer.parseInt(scanner.nextLine());
        int colSize = Integer.parseInt(scanner.nextLine());
        int numberOfMoves = Integer.parseInt(scanner.nextLine());
        int[] code = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int coeff = Math.max(rowSize, colSize);

        BigInteger[][] matrixField = new BigInteger[rowSize][colSize];
        matrixField[rowSize - 1][0] = BigInteger.valueOf(1);

        fillingMatrix(rowSize, colSize, matrixField);


        BigInteger sum = BigInteger.ZERO;
        int currentRow = rowSize - 1;
        int currentCol = 0;

        for (int i = 0; i < numberOfMoves; i++) {
            int targetRow = code[i] / coeff;
            int targetCol = code[i] % coeff;
            if (currentCol < targetCol) {
                for (int horizont = currentCol; horizont <= targetCol; horizont++) {
                    sum = sum.add(matrixField[currentRow][horizont]);
                    matrixField[currentRow][horizont] = BigInteger.valueOf(0);
                }
                currentCol = targetCol;
            } else if (currentCol > targetCol) {

                for (int horizont = currentCol; horizont >= targetCol; horizont--) {
                    sum = sum.add(matrixField[currentRow][horizont]);
                    matrixField[currentRow][horizont] = BigInteger.valueOf(0);

                }
                currentCol = targetCol;
            }
            if (currentRow < targetRow) {
                for (int vertical = currentRow; vertical <= targetRow; vertical++) {
                    sum = sum.add(matrixField[vertical][currentCol]);
                    matrixField[vertical][currentCol] = BigInteger.valueOf(0);
                }
                currentRow = targetRow;
            } else if (currentRow > targetRow) {

                for (int vertical = currentRow; vertical >= targetRow; vertical--) {
                    sum = sum.add(matrixField[vertical][currentCol]);
                    matrixField[vertical][currentCol] = BigInteger.valueOf(0);
                }
                currentRow = targetRow;
            }
        }
        System.out.println(sum);
    }

    private static void fillingMatrix(int rowSize, int colSize, BigInteger[][] matrixField) {
        for (int row = rowSize - 1; row >= 0; row--) {
            for (int col = 0; col < colSize; col++) {
                boolean check = true;
                if (row == rowSize - 1 && col == 0) {
                    check = false;
                }
                if (row < rowSize - 1 && check) {
                    matrixField[row][col] = matrixField[row + 1][col].multiply(BigInteger.valueOf(2));
                } else if (check){
                    matrixField[row][col] = matrixField[row][col - 1].multiply(BigInteger.valueOf(2));
                }
            }
        }
    }
}