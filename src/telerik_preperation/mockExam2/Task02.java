package telerik_preperation.mockExam2;

import java.util.Scanner;

public class Task02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String n = scanner.nextLine();
        int oddSum = 0;
        int evenSum = 0;

        for (int i = 0; i < n.length(); i++) {
            int currentNum = Integer.parseInt(String.valueOf(n.charAt(i)));
            if (currentNum % 2 == 0) {
                evenSum += currentNum;
            } else {
                oddSum += currentNum;
            }
        }

        if (oddSum > evenSum) {
            System.out.println(oddSum + " cups of coffee");
        } else if (evenSum>oddSum) {
            System.out.println(evenSum + " energy drinks");
        }else {
            System.out.println(oddSum + " of both");
        }

    }
}
