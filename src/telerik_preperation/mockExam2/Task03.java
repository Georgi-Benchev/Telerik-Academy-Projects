package telerik_preperation.mockExam2;

import java.util.Arrays;
import java.util.Scanner;

public class Task03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] input = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        int n = Integer.parseInt(scanner.nextLine());

        if (input.length == 1) {
            System.out.println("[" + input[0] + "]");
        } else {
            StringBuilder print = new StringBuilder("[" + input[0] + ", ");

            for (int i = 1; i < input.length - 1; i++) {
                if (input[i] == n) {
                    int plusNum = input[i + 1];
                    int minusNum = input[i - 1];

                    if (plusNum == n || minusNum == n) {
                        print.append(input[i]).append(", ");
                    } else if (plusNum > minusNum) {
                        print.append(plusNum).append(", ");
                    } else {
                        print.append(minusNum).append(", ");
                    }

                } else {
                    print.append(input[i]).append(", ");
                }

            }

            System.out.println(print.toString() + input[input.length - 1] + "]");
        }
    }
}