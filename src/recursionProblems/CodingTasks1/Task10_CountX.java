package recursionProblems.CodingTasks1;

import java.util.Scanner;

public class Task10_CountX {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        System.out.println(CountX(input));
    }

    public static int CountX(String input) {

        if (input.length() > 1) {
            if ('x' == input.charAt(0)) {
                return 1 + CountX(input.substring(1));
            }
            return CountX(input.substring(1));
        } else {
            if (input.equals("x")) {
                return 1;
            }
            return 0;
        }
    }
}
