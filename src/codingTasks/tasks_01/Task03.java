package codingTasks.tasks_01;

import java.util.Arrays;
import java.util.Scanner;

public class Task03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] sizes = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] numbersOne = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] numbersTwo = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] output = new int[Math.max(sizes[0], sizes[1])];

        for (int i = 0; i < output.length; i++) {
            int numOne;
            int numTwo;
            if (numbersOne.length - 1 >= i) {
                numOne = numbersOne[i];
            } else {
                numOne = 0;
            }
            if (numbersTwo.length - 1 >= i) {
                numTwo = numbersTwo[i];
            } else {
                numTwo = 0;
            }

            int remainingNum = 0;
            int finalNum = output[i] + numOne + numTwo;
            if (finalNum >= 10) {
                remainingNum = finalNum / 10;
                if (i == output.length - 1) {
                    output[i] = finalNum;
                } else {
                    output[i + 1] = remainingNum;
                    output[i] = finalNum % 10;
                }

            } else {
                output[i] = finalNum;
            }
        }

        for (int num : output) {
            System.out.print(num + " ");
        }

    }
}