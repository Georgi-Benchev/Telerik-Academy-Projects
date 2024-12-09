package recursionProblems.CodingTasks1;

import java.util.Arrays;
import java.util.Scanner;

public class Task13_ArrayWith6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        int index = Integer.parseInt(scanner.nextLine());

        System.out.println(DoesItContain6(numbers, index));
    }

    public static boolean DoesItContain6(int[] numbers, int index) {

        if (index < numbers.length) {
            if (numbers[index] == 6) {
                return true;
            } else {
                return DoesItContain6(numbers, index + 1);
            }
        }
        return false;
    }
}
