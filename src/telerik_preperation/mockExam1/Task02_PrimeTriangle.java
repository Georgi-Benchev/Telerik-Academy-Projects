package telerik_preperation.mockExam1;

import java.util.Scanner;

public class Task02_PrimeTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        boolean[] isPrime = new boolean[n];

        isPrime[0] = true;
        isPrime[1] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    isPrime[i - 1] = false;
                    break;
                } else {
                    isPrime[i - 1] = true;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (isPrime[i]) {
                for (int j = 0; j <= i; j++) {
                    if (isPrime[j]) {
                        System.out.print("1");
                    } else {
                        System.out.print("0");
                    }
                }
                System.out.println();
            }
        }

    }
}
