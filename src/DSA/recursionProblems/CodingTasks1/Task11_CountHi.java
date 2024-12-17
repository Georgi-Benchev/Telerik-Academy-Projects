package DSA.recursionProblems.CodingTasks1;

import java.util.Scanner;

public class Task11_CountHi {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        System.out.println(CountHi(input));
    }

    public static int CountHi(String input) {

        if (input.length() > 2) {
            if ("hi".equals(input.substring(0, 2))) {
                return 1 + CountHi(input.substring(1));
            }
            return CountHi(input.substring(1));
        } else {
            if (input.equals("hi")) {
                return 1;
            }
            return 0;
        }
    }
}