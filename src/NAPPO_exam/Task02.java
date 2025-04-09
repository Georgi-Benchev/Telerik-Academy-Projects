package NAPPO_exam;

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Task02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] input = Arrays.stream(scanner.nextLine().split(","))
                .mapToInt(Integer::parseInt)
                .toArray();

        HashMap<Integer, Integer> resultTable = new HashMap<>();

        for (int i = 0; i < input.length; i++) {
            int currentNum = input[i];

            if (resultTable.containsKey(currentNum)) {
                resultTable.put(currentNum, resultTable.get(currentNum) + 1);
            } else {
                resultTable.put(currentNum, 1);
            }
        }

        boolean checkSizes = !resultTable.isEmpty();

        PriorityQueue<Integer> results = new PriorityQueue<>();
        for (Integer num : resultTable.values()) {
            results.add(num);
        }

        int min = results.peek();
        if (min <= 1) {
            checkSizes = false;
        } else {


            for (int i = 0; i < results.size(); i++) {
                int currentNum = results.poll();
                if (currentNum % min != 0 || currentNum <= 1) {
                    checkSizes = false;
                    break;
                }
            }
        }

        System.out.println(checkSizes);
    }
}
