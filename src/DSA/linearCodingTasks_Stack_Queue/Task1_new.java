package DSA.linearCodingTasks_Stack_Queue;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Task1_new {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        int[] input = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        int[] jumps = new int[size];
        Stack<Integer> stackIndexes = new Stack<>();

        for (int i = size - 1; i >= 0; i--) {
            while (!stackIndexes.isEmpty() && input[stackIndexes.peek()] <= input[i]) {
                stackIndexes.pop();
            }
            jumps[i] = stackIndexes.size();
            stackIndexes.push(i);
        }

        int max = Arrays.stream(jumps).max().orElse(0);

        System.out.println(max);
        Arrays.stream(jumps).forEach(e -> System.out.print(e + " "));
    }
}
