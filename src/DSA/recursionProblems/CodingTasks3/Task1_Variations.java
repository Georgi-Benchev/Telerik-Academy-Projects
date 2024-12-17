package DSA.recursionProblems.CodingTasks3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task1_Variations {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        String chars = reader.readLine();
        char a = chars.charAt(0);
        char b = chars.charAt(2);
        if (a > b) {
            char local = b;
            b = a;
            a = local;
        }

        findAllCombinations(n, a, b, new StringBuilder());
    }


    // aa
    // ab
    // ba
    // bb
    private static void findAllCombinations(int n, char a, char b, StringBuilder current) {
        if (n == 0) {
            System.out.println(current);
            return;
        }
        int length = current.length();
        current.append(a);
        findAllCombinations(n - 1, a, b, current);

        current.setLength(length);
        current.append(b);
        findAllCombinations(n - 1, a, b, current);
        current.setLength(length);
    }
}
