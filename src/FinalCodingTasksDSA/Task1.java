package FinalCodingTasksDSA;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String[] input = scanner.nextLine().split(" ");

        Queue<String> sergeants = new LinkedList<>();
        Queue<String> corporals = new LinkedList<>();
        Queue<String> soldiers = new LinkedList<>();

        char local;
        for (int i = 0; i < input.length; i++) {
            local = input[i].charAt(0);
            if (local == 'S') {
                sergeants.offer(input[i]);
            } else if (local == 'C') {
                corporals.offer(input[i]);
            } else if (local == 'P') {
                soldiers.offer(input[i]);
            }
        }

        StringBuilder output = new StringBuilder();

        int temp = sergeants.size();
        for (int i = 0; i < temp; i++) {
            output.append(sergeants.poll()).append(" ");
        }

        temp = corporals.size();
        for (int i = 0; i < temp; i++) {
            output.append(corporals.poll()).append(" ");
        }

        temp = soldiers.size();
        for (int i = 0; i < temp; i++) {
            output.append(soldiers.poll()).append(" ");
        }

        System.out.println(output.substring(0, output.length() - 1));

    }
}
