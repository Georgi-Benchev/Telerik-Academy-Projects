package recursionProblems.CodingTasks1;

import java.util.Scanner;

public class Task1_Factorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        System.out.println(Factorial(n));

    }

    public static int Factorial(int n) {
        if (n == 1) {
            return 1;
        }

        return n * Factorial(n - 1);
    }
}
