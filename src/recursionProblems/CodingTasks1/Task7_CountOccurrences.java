package recursionProblems.CodingTasks1;

import java.util.Scanner;

public class Task7_CountOccurrences {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        System.out.println(occurrencesOfSeven(input));
    }

    public static int occurrencesOfSeven(String input) {

        if (!input.isEmpty()) {
            if (Integer.parseInt(String.valueOf(input.charAt(0))) == 7) {
                return 1 + occurrencesOfSeven(input.substring(1));
            }
            return occurrencesOfSeven(input.substring(1));
        } else {
            return 0;
        }
    }
}
