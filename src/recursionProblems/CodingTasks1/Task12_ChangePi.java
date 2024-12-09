package recursionProblems.CodingTasks1;

import java.util.Scanner;

public class Task12_ChangePi {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        System.out.println(ChangePi(input, input.length() - 2));
    }

    public static String ChangePi(String input, int position) {

        if (position >= 0) {
            if ("pi".equals(input.substring(position, position + 2))) {
                input = input.substring(0, position) + "3.14" + input.substring(position + 2);
            }
            return ChangePi(input, position - 1);
        } else {
            return input;
        }
    }
}
