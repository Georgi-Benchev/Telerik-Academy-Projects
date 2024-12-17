package DSA.recursionProblems.CodingTasks3;

import java.util.Scanner;

public class Task1_rewriteForPractise {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int length = scanner.nextInt();
        scanner.nextLine();
        String input = scanner.nextLine();
        char char1 = input.charAt(0);
        char char2 = input.charAt(2);
        if (char1 < char2) {
            variations(char1, char2, length, "");
        } else {
            variations(char2, char1, length, "");
        }

    }

    private static void variations(char char1, char char2, int length, String output) {
        if (length == 0) {
            System.out.println(output);
            return;
        }
        variations(char1, char2, length - 1, output + char1);
        variations(char1, char2, length - 1, output + char2);
    }
}
