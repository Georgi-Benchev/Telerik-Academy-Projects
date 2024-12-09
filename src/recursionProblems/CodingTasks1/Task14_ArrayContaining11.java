package recursionProblems.CodingTasks1;

import java.util.Arrays;
import java.util.Scanner;

public class Task14_ArrayContaining11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int[] numbers = Arrays.stream(scanner.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        int index = Integer.parseInt(scanner.nextLine());

        System.out.println(ContThe11s(numbers, index));
    }

    public static int ContThe11s(int[] numbers, int index) {

        if (index < numbers.length) {
            if (numbers[index] == 11) {
                return 1 + ContThe11s(numbers, index + 1);
            } else {
                return ContThe11s(numbers, index + 1);
            }
        }
        return 0;
    }
}
