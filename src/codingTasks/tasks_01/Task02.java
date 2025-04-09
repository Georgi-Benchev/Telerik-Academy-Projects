package codingTasks.tasks_01;

import java.util.Scanner;

public class Task02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int bestSum = 1;
        int newSum = 1;
        int lastNum = 0;

        for (int i = 0; i < n; i++) {
            int newNum = Integer.parseInt(scanner.nextLine());
            if (newNum == lastNum) {
                newSum++;
            } else {
                lastNum = newNum;
                newSum = 1;
            }
            if (bestSum <= newSum) {
                bestSum = newSum;
            }
        }

        System.out.println(bestSum);
    }
}
