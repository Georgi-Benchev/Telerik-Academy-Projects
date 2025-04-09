package telerik_preperation.mockExam1;

import java.util.Scanner;

public class Task03_BalancedNumbers {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int sum = 0;
        String inputLine;
        boolean checkNumber = true;

        while (checkNumber) {
            inputLine = scanner.nextLine();
            int a = Integer.parseInt(String.valueOf(inputLine.charAt(0)));
            int b = Integer.parseInt(String.valueOf(inputLine.charAt(1)));
            int c = Integer.parseInt(String.valueOf(inputLine.charAt(2)));

            if (a + c == b) {
                sum += Integer.parseInt(inputLine);
            } else {
                checkNumber = false;
            }
        }

        System.out.println(sum);

    }
}