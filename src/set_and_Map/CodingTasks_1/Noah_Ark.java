package set_and_Map.CodingTasks_1;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Noah_Ark {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());


        Map<String, Integer> noahArk = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();

            if (noahArk.containsKey(input)) {
              /*  int newCount = noahArk.get(input);
                newCount++;*/
                noahArk.put(input, 1 + noahArk.get(input));
            } else {
                noahArk.put(input, 1);
            }

        }


        noahArk.forEach((K, V) -> System.out.printf("%s %d %s%n", K, V, V % 2 == 0 ? "Yes" : "No"));


    }
}
