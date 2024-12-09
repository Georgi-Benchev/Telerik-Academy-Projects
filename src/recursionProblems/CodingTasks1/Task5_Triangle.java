package recursionProblems.CodingTasks1;

import java.util.Scanner;

public class Task5_Triangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());

        System.out.println(blockCounter(rows));

    }

    public static int blockCounter(int n) {
        if (n == 0) {
            return 0;
        }

        return n + blockCounter(n - 1);

    }
}
