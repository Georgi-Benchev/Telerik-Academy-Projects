package codingTasks.tasks_02;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class Task02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int curentPosition = Integer.parseInt(scanner.nextLine());
        int[] values = Arrays.stream(scanner.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        BigInteger forwardCount = BigInteger.valueOf(0);
        BigInteger backwardsCount = BigInteger.valueOf(0);

        String input = scanner.nextLine();

        while (!input.equals("exit")) {
            String[] commands = input.split(" ");
            int moves = Integer.parseInt(commands[0]);
            String direction = commands[1];
            int sizeOfMoves = Integer.parseInt(commands[2]);
            sizeOfMoves = sizeOfMoves % values.length;


            if (direction.equals("forward")) {
                for (int i = 0; i < moves; i++) {
                    if (curentPosition + sizeOfMoves < values.length) {
                        curentPosition += sizeOfMoves;
                        forwardCount = forwardCount.add(BigInteger.valueOf(values[curentPosition]));
                    } else {
                        curentPosition = Math.abs(values.length - (sizeOfMoves + curentPosition));
                        forwardCount = forwardCount.add(BigInteger.valueOf(values[curentPosition]));
                    }
                }
            } else if (direction.equals("backwards")) {
                for (int i = 0; i < moves; i++) {
                    if (curentPosition - sizeOfMoves >= 0) {
                        curentPosition -= sizeOfMoves;
                        backwardsCount = backwardsCount.add(BigInteger.valueOf(values[curentPosition]));
                    } else {
                        curentPosition = values.length + (curentPosition - sizeOfMoves);
                        backwardsCount = backwardsCount.add(BigInteger.valueOf(values[curentPosition]));
                    }

                }
            }
            input = scanner.nextLine();

        }
        System.out.println("Forward: " + forwardCount);
        System.out.println("Backwards: " + backwardsCount);
    }
}