package codingTasks.tasks_01;

import java.util.ArrayList;
import java.util.Scanner;

public class Task01 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        ArrayList<Integer> primeNumbers = new ArrayList<>();
        primeNumbers.add(1);

        for (int number = 2; number <= n; number++) {
            boolean check = true;
            for (int i = 2; i <= number/2; i++) {
                if (number % i == 0) {
                    check = false;
                    break;
                }
            }
            if (check) {
                primeNumbers.add(number);
            }

        }

        for (int num : primeNumbers) {
            System.out.print(num + " ");
        }
    }
}