package recursionProblems.CodingTasks1;

import java.util.Arrays;
import java.util.Scanner;

public class Task15_ArrayValuesTimes10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        int startIndex = Integer.parseInt(scanner.nextLine());
        int localIndex = startIndex + 1;

        System.out.println(CheckArrayFOrTimes10(numbers, startIndex, localIndex));
    }

    public static boolean CheckArrayFOrTimes10(int[] numbers, int startIndex, int localIndex) {

        if (numbers.length > localIndex - 1 || numbers.length > startIndex) {
            if (startIndex == numbers.length) {
                return false;
            } else if (localIndex == numbers.length) {
                return CheckArrayFOrTimes10(numbers, startIndex + 1, startIndex + 2);

            } else {
                if (numbers[startIndex] * 10 == numbers[localIndex]) {
                    return true;
                }
                return CheckArrayFOrTimes10(numbers, startIndex, localIndex + 1);
            }
        }
        return false;
    }
}
