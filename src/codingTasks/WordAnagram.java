package codingTasks;

import java.util.Arrays;
import java.util.Scanner;

public class WordAnagram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int n = Integer.parseInt(scanner.nextLine());
        char[] sortedInput = input.toLowerCase().toCharArray();
        Arrays.sort(sortedInput);

        String[] isItAnagram = new String[n];

        String inputLine;
        for (int i = 0; i < n; i++) {
            inputLine = scanner.nextLine();
            char[] checkLine = inputLine.toLowerCase().toCharArray();
            Arrays.sort(checkLine);

            if (sortedInput.length != checkLine.length) {
                isItAnagram[i] = "No";
            } else {
                for (int j = 0; j < sortedInput.length; j++) {
                    if (checkLine[j] != sortedInput[j]) {
                        isItAnagram[i] = "No";
                        break;
                    } else {
                        isItAnagram[i] = "Yes";
                    }
                }

            }
        }

        for (int i = 0; i < isItAnagram.length; i++) {
            System.out.println(isItAnagram[i]);
        }
    }
}
