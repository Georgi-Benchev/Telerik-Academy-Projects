package telerik_preperation.mockExam3;

import java.util.Scanner;

public class Task03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String title = scanner.nextLine();
        int n = Integer.parseInt(scanner.nextLine());
        String[] outputs = new String[n];

        for (int i = 0; i < n; i++) {
            char[] input = scanner.nextLine().toCharArray();
            StringBuilder demoTitle = new StringBuilder(title);
            int count = 0;
            int pos = 0;

            for (char ch: input) {
                while (pos < demoTitle.length()) {
                    if (ch == demoTitle.charAt(pos)) {
                        demoTitle.deleteCharAt(pos);
                        count++;
                        break;
                    }
                    pos++;
                }
            }
            if (count == input.length) {
                title = demoTitle.toString();
                outputs[i] = title;
            } else {
                outputs[i] = "No such title found!";
            }

        }
        for (String out : outputs) {
            System.out.println(out);
        }

    }
}