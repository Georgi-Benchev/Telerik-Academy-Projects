package recursionProblems.CodingTasks1;

import java.util.Scanner;

public class Task9_PowerN {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        int power = Integer.parseInt(scanner.nextLine());

        System.out.println(powerN(number, power));
    }

    public static int powerN(int number, int power) {

        if (power == 1) {
            return number;
        } else {
            return number * powerN(number, power - 1);
        }
    }
}
