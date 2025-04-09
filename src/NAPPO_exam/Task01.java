package NAPPO_exam;

import java.util.Scanner;

public class Task01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        int result = 0;
        int zeroes = 0;
        int ones = 0;
        boolean hasZeroes = false;
        boolean completedCycle = false;

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);

            if (currentChar == '0') {
                if (completedCycle) {
                    int localResult = Math.min(zeroes, ones) * 2;
                    if (localResult > result) {
                        result = localResult;
                    }
                    ones = 0;
                    zeroes = 0;
                    completedCycle = false;
                }

                hasZeroes = true;
                zeroes++;
            } else {
                if (hasZeroes || completedCycle) {

                    ones++;
                    hasZeroes = false;
                    completedCycle = true;
                }
            }
        }

        int finalCheck = Math.min(ones, zeroes) * 2;
        if (result<finalCheck){
            result = finalCheck;
        }

        System.out.println(result);
    }
}
