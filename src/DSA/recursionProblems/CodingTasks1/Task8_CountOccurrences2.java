package DSA.recursionProblems.CodingTasks1;

import java.util.Scanner;

public class Task8_CountOccurrences2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        System.out.println(occurrencesOfEight(input));
    }

    public static int occurrencesOfEight(String input) {

        if (input.length() > 1) {
            if (Integer.parseInt(String.valueOf(input.charAt(0))) == 8) {
                if (Integer.parseInt(String.valueOf(input.charAt(1))) == 8) {
                    return 2 + occurrencesOfEight(input.substring(1));
                }
                return 1 + occurrencesOfEight(input.substring(1));
            }
            return occurrencesOfEight(input.substring(1));
        } else {
            if (Integer.parseInt(input) == 8) {
                return 1;
            }
            return 0;
        }
    }
}
