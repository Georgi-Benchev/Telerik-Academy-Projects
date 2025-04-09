package codingTasks.tasks_03_optimized;

import java.util.Scanner;

public class Task02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("");

        int count = 1;
        int bestCount = 0;
        StringBuilder output = new StringBuilder(input[0]);
        StringBuilder bestOutput = new StringBuilder(input[0]);
        for (int i = 1; i < input.length; i++) {
            if (input[i].equals(input[i - 1])) {
                count++;
                output.append(input[i]);
                if (count > bestCount) {
                    bestOutput = new StringBuilder();
                    for (int j = 0; j < count; j++) {
                        bestOutput.append(output.charAt(0));
                    }

                    bestCount = count;
                }
            } else {
                count = 1;
                output = new StringBuilder();
            }
        }

        System.out.println(bestOutput);
    }
}