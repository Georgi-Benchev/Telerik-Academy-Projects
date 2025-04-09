package telerik_preperation.mockExam4;

import java.util.Scanner;

public class Task03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String[] inputLine = new String[n];
        int bestIndex = -1;
        int bestSum = -1;

        for (int i = 0; i < n; i++) {
            inputLine[i] = scanner.nextLine();
            int localSum = 0;
            char[] singleLetters = inputLine[i].toCharArray();
            for (int j = 0; j < singleLetters.length; j++) {
                localSum += Character.toLowerCase(singleLetters[j]) - 96;
            }

            if (localSum > bestSum) {
                bestSum = localSum;
                bestIndex = i;
            }

        }

        System.out.println(bestSum + " " + inputLine[bestIndex]);

    }
}