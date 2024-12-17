package FinalCodingTasksDSA;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = scanner.nextInt();
        int pos = scanner.nextInt();

        int[] memorisation = new int[pos];
        for (int i = 1; i <= pos; i++) {
            getPos1(num, i, memorisation);

        }
        System.out.println(memorisation[pos - 1]);
    }

    private static void getPos1(int num, int pos, int[] memorisation) {
        int specialPos = pos % 3;
        if (pos == 1) {
            memorisation[0] = num;


        } else if (specialPos == 2) {
            memorisation[pos - 1] = memorisation[pos / 3] + 1;

        } else if (specialPos == 0) {
            memorisation[pos - 1] = 2 * memorisation[(pos - 1) / 3] + 1;

        } else if (specialPos == 1) {
            memorisation[pos - 1] = memorisation[(pos - 2) / 3] + 2;
        }
    }

    // 2 10
    // 2   3 5 4  4 7 5

}
