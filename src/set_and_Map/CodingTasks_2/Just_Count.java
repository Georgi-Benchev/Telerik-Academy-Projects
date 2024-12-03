package set_and_Map.CodingTasks_2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Just_Count {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[] input = scanner.nextLine().toCharArray();

        Map<Character, Integer> specialSymbols = new HashMap<>();
        Map<Character, Integer> lowerCharacters = new HashMap<>();
        Map<Character, Integer> upperCharacters = new HashMap<>();

        for (char ch : input) {
            if (ch >= 97 && ch <= 122) {  // a-z
                if (!lowerCharacters.containsKey(ch)) {
                    lowerCharacters.put(ch, 1);
                } else {
                    lowerCharacters.put(ch, lowerCharacters.get(ch) + 1);
                }
            } else if (ch >= 65 && ch <= 90) {  // A-Z
                if (!upperCharacters.containsKey(ch)) {
                    upperCharacters.put(ch, 1);
                } else {
                    upperCharacters.put(ch, upperCharacters.get(ch) + 1);
                }
            } else { // &^%$$&^
                if (!specialSymbols.containsKey(ch)) {
                    specialSymbols.put(ch, 1);
                } else {
                    specialSymbols.put(ch, specialSymbols.get(ch) + 1);
                }
            }
        }


        getBiggestCharCount(specialSymbols);
        getBiggestCharCount(lowerCharacters);
        getBiggestCharCount(upperCharacters);


    }

    private static void getBiggestCharCount(Map<Character, Integer> mapToWorkWith) {
        Character biggestChar = ' ';
        Integer maxValue = 0;
        for (Map.Entry<Character, Integer> entry : mapToWorkWith.entrySet()) {
            if (maxValue < entry.getValue()) {
                biggestChar = entry.getKey();
                maxValue = entry.getValue();
            } else if (maxValue == entry.getValue() && biggestChar > entry.getKey()) {
                biggestChar = entry.getKey();
                maxValue = entry.getValue();
            }
        }
        if (maxValue == 0) {
            System.out.println("-");
        } else {
            System.out.println(biggestChar + " " + maxValue);
        }

    }
}
