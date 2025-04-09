package telerik_preperation.mockExam1;

import java.util.Scanner;

public class Task01_CrookedDigits {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("");
        int sum = 0;

        for (int i = 0; i < input.length; i++) {
            String isItDigit = input[i];
            if (isItDigit.charAt(0) >= 48 && isItDigit.charAt(0) <= 57) {
                sum += Integer.parseInt(isItDigit);
            }
        }

        while (sum > 9) {
            String[] newInput = String.valueOf(sum).split("");
            sum = 0;
            for (int i = 0; i < newInput.length; i++) {
                sum += Integer.parseInt(newInput[i]);
            }
        }
        System.out.println(sum);

    }
}