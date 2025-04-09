package telerik_preperation.mockExam4;

import java.util.Scanner;

public class Task02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < input.length; i++) {
            boolean bonusEcheck = false;
            String word = input[i];
            if (word.length() % 2 == 0) {
                bonusEcheck = true;
            }
            if (word.charAt(0) == 'a'
                    || word.charAt(0) == 'e'
                    || word.charAt(0) == 'i'
                    || word.charAt(0) == 'o'
                    || word.charAt(0) == 'u'
                    || word.charAt(0) == 'A'
                    || word.charAt(0) == 'E'
                    || word.charAt(0) == 'I'
                    || word.charAt(0) == 'O'
                    || word.charAt(0) == 'U') {
                if (bonusEcheck) {
                    output.append(word.substring(1, word.length())).append(word.charAt(0)).append("chee ");
                } else {
                    output.append(word.substring(1, word.length())).append(word.charAt(0)).append("che ");
                }
            } else {
                if (bonusEcheck) {
                    output.append(word).append("chee ");
                } else {
                    output.append(word).append("che ");
                }
            }


        }
        System.out.println(output.substring(0, output.length() - 1));

    }
}
