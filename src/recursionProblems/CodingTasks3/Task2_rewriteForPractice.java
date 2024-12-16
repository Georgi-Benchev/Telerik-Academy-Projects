package recursionProblems.CodingTasks3;

import java.util.*;

public class Task2_rewriteForPractice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String cypher = scanner.nextLine();
        char[] codesInput = scanner.nextLine().toCharArray();

        Map<String, Character> codesMap = new HashMap<>();
        fillMapWithCodes(codesInput, codesMap);

        Set<String> cypherCodes = new HashSet<>();
        decipherCombinationsFromMap(cypherCodes, codesMap, cypher);

        System.out.println(cypherCodes.size());
        cypherCodes.stream().sorted().forEach(System.out::println);

    }

    private static void decipherCombinationsFromMap(Set<String> setToFill, Map<String, Character> codesMap, String cypher) {
        decipherHelper(setToFill, codesMap, cypher, "");
    }

    private static void decipherHelper(Set<String> setToFill, Map<String, Character> codesMap, String cypher, String result) {
        if ("".equals(cypher)) {
            setToFill.add(result);
            return;
        }
        for (int i = 1; i <= cypher.length(); i++) {
            if (codesMap.containsKey(cypher.substring(0, i))) {
                decipherHelper(setToFill, codesMap, cypher.substring(i), result + codesMap.get(cypher.substring(0, i)));
            }
        }
    }

    private static void fillMapWithCodes(char[] codesInput, Map<String, Character> codesMap) {
        StringBuilder digit = new StringBuilder();
        char letter = 1;
        char current;
        for (int i = 0; i < codesInput.length; i++) {
            current = codesInput[i];

            if (current >= 'A' && current <= 'Z') {
                if (letter == 1) {
                    letter = current;
                } else {
                    codesMap.put(digit.toString(), letter);
                    digit = new StringBuilder();
                    letter = current;
                }
            } else {
                digit.append(current);
            }
        }
        codesMap.put(digit.toString(), letter);
    }
}
