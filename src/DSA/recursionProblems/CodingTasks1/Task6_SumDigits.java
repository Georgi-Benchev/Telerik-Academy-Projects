package DSA.recursionProblems.CodingTasks1;

import java.util.Scanner;

public class Task6_SumDigits {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        System.out.println(sumAlgorithm(input));
    }

    public static int sumAlgorithm(String input) {
        if (input.length() == 1) {
            return Integer.parseInt(input);
        }

        return Integer.parseInt(String.valueOf(input.charAt(input.length() - 1)))
                + sumAlgorithm(input.substring(0, input.length() - 1));
    }
}
