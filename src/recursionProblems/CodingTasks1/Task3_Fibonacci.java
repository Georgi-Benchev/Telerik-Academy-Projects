package recursionProblems.CodingTasks1;

import java.util.Scanner;

public class Task3_Fibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        System.out.println(Fibonacci(n, 0, 1));


    }

    public static long Fibonacci(int n, long num1, long num2) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else if (n == 2) {
            return num1 + num2;
        } else {
            return Fibonacci(n - 1, num2, num1 + num2);
        }
    }
}
