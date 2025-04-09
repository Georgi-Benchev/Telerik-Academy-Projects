package telerik_preperation.examTelerikAcademyAugust2024;

import java.util.Arrays;
import java.util.Scanner;

public class Task03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbersLine1 = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] numbersLine2 = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < Math.max(numbersLine1.length, numbersLine2.length); i++) {
            if (numbersLine1.length <= i) {
                System.out.printf("- x %d%n", numbersLine2[i]);
            } else if (numbersLine2.length <= i) {
                System.out.printf("- %d x%n", numbersLine1[i]);
            } else {
                if (numbersLine1[i] == numbersLine2[i]) {
                    System.out.printf("+ %d %d%n", numbersLine1[i], numbersLine2[i]);
                } else {
                    System.out.printf("- %d %d%n", numbersLine1[i], numbersLine2[i]);
                }

            }
        }

    }
}