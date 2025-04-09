package telerik_preperation.mockExam2;

import java.util.Arrays;
import java.util.Scanner;

public class Task01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(scanner.nextLine());
        }
        Arrays.sort(numbers);

        if (numbers.length == 1) {
            System.out.println(numbers[0]);
        } else {

            int bestNumber = Integer.MAX_VALUE;
            int bestCount = 0;
            int count = 0;

            for (int i = 0; i < n - 1; i++) {


                if (numbers[i] == numbers[i + 1]) {
                    count++;
                } else {
                    count = 0;
                }
                if (count > bestCount) {
                    bestNumber = numbers[i];
                    bestCount = count;
                } else if (count == bestCount && numbers[i] < bestNumber) {
                    bestNumber = numbers[i];
                }


            }

            System.out.println(bestNumber);
        }
    }
}
