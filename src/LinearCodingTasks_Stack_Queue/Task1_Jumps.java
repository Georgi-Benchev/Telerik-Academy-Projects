package LinearCodingTasks_Stack_Queue;

import java.util.Arrays;

import java.util.Scanner;

public class Task1_Jumps {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        int[] input = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        int max = 0;

        for (int i = 0; i < input.length; i++) {
            int current = input[i];
            int jumps = 0;
            for (int j = i + 1; j < input.length; j++) {

                if (current < input[j]) {
                    jumps++;
                    current = input[j];
                }
            }
            if (jumps > max) {
                max = jumps;
            }
            input[i] = jumps;
        }

        System.out.println(max);
        Arrays.stream(input).forEach(e -> System.out.print(e + " "));

    }
}
