package recursionProblems.CodingTasks3;

import java.util.*;

public class Task2_Cipher {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String cypher = scanner.nextLine();

        String message = scanner.nextLine();
        Map<String, Character> decipher = getDecipher(message);

        Set<String> outputs = new HashSet<>();
        findNext2(decipher, cypher, "", outputs);
        /*findNext(decipher, cypher, "", outputs);*/

        System.out.println(outputs.size());
        outputs.stream().sorted().forEach(System.out::println);
    }

    private static void findNext(Map<String, Character> newMap, String cypher, String stringSoFar, Set<String> outputs) {
        if (cypher.isEmpty()) {
            outputs.add(stringSoFar);
            return;
        }

        for (int length = 1; length <= cypher.length(); length++) {
            String code = cypher.substring(0, length);

            if (newMap.containsKey(code)) {
                char letter = newMap.get(code);
                findNext(newMap, cypher.substring(length), stringSoFar + letter, outputs);
            }
        }
    }

    private static void findNext2(Map<String, Character> newMap, String cypher, String stringSoFar, Set<String> outputs) {
        if (cypher.isEmpty()) {
            outputs.add(stringSoFar);
            return;
        }
        for (Map.Entry<String, Character> entry : newMap.entrySet()) {

            if (cypher.length() >= entry.getKey().length()
                    && cypher.substring(0, entry.getKey().length()).equals(entry.getKey())) {

                findNext2(newMap, cypher.substring(entry.getKey().length()), stringSoFar + entry.getValue(), outputs);
            }
        }
    }


    private static Map<String, Character> getDecipher(String message) {
        char[] chars = message.toCharArray();
        List<Character> letters = new ArrayList<>();
        List<String> digits = new ArrayList<>();

        Map<String, Character> decipher = new HashMap<>();
        for (char n : chars) {
            if (n <= 'Z' && n >= 'A') {
                letters.add(n);
            } else {
                if (digits.size() < letters.size()) {
                    digits.add(String.valueOf(n));
                } else {
                    if (digits.size() == 0) {
                        digits.add(String.valueOf(n));
                    } else {
                        digits.set(digits.size() - 1, digits.get(digits.size() - 1) + n);
                    }
                }
            }
        }
        for (int i = 0; i < letters.size(); i++) {
            decipher.put(digits.get(i), letters.get(i));
        }
        return decipher;
    }


}
