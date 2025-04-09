package telerik_preperation.mockExam3;

import java.util.Scanner;

public class Task01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String commands = scanner.nextLine();
        int upDown = 0;
        int leftRight = 0;

        for (int i = 0; i < commands.length(); i++) {
            char command = commands.charAt(i);
            switch (command) {
                case 'L':
                    leftRight--;
                    break;
                case 'R':
                    leftRight++;
                    break;
                case 'U':
                    upDown++;
                    break;
                case 'D':
                    upDown--;
                    break;
            }
        }

        System.out.printf("(%d, %d)", leftRight, upDown);

    }
}
