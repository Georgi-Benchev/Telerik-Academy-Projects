package codingTasks.tasks_03_optimized;

import java.util.Scanner;

public class Task01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int arraySize = Integer.parseInt(scanner.nextLine());
        int[] inputArray = new int[arraySize];

        for (int i = 0; i < arraySize; i++) {
            inputArray[i] = Integer.parseInt(scanner.nextLine());
        }

        int count = 1;
        int bestCount = 0;
        for (int i = 1; i < arraySize; i++) {
            if (inputArray[i] > inputArray[i - 1]) {
                count++;
                if (count >= bestCount) {
                    bestCount = count;
                }
            } else {
                count = 1;
            }
        }

        System.out.println(bestCount);
    }
}
