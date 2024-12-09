package recursionProblems.CodingTasks1;

import java.util.Scanner;

public class Task2_BunnyEars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfBunnies = Integer.parseInt(scanner.nextLine());
        System.out.println(bunnyEarsCounter(numberOfBunnies));

    }

    public static int bunnyEarsCounter(int n) {

        if (n == 0) {
            return 0;
        }
        return 2 + bunnyEarsCounter(n - 1);
    }

}
