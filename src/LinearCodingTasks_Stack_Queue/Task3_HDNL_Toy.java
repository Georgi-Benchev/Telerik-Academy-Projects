package LinearCodingTasks_Stack_Queue;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Task3_HDNL_Toy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        ArrayDeque<String> output = new ArrayDeque<>();
        ArrayDeque<String> stack = new ArrayDeque<>();


        for (int i = 0; i < size; i++) {
            String local = scanner.nextLine();

            if (stack.isEmpty()) {
                StringBuilder sb = new StringBuilder();
                sb.append("<");
                sb.append(local);
                sb.append(">");

                stack.push(local);
                output.offer(String.valueOf(sb));
            } else {
                int lastValueInStack = Integer.parseInt(stack.peek().substring(1, stack.peek().length()));
                int localValue = Integer.parseInt(local.substring(1, local.length()));

                if (localValue > lastValueInStack) {

                    StringBuilder sb = new StringBuilder();
                    for (int j = 0; j < stack.size(); j++) {
                        sb.append(" ");
                    }

                    sb.append("<");
                    sb.append(local);
                    sb.append(">");
                    output.offer(String.valueOf(sb));
                    stack.push(local);

                } else {
                    while (!stack.isEmpty() && Integer.parseInt(stack.peek().substring(1, stack.peek().length())) >= localValue) {
                        StringBuilder sb = new StringBuilder();
                        for (int j = 0; j < stack.size() - 1; j++) {
                            sb.append(" ");
                        }
                        sb.append("</");
                        sb.append(stack.peek());
                        sb.append(">");
                        output.offer(String.valueOf(sb));

                        stack.pop();


                    }
                    StringBuilder sb = new StringBuilder();
                    for (int j = 0; j < stack.size(); j++) {
                        sb.append(" ");
                    }
                    sb.append("<");
                    sb.append(local);
                    sb.append(">");
                    output.offer(String.valueOf(sb));
                    stack.push(local);


                }
            }


        }

        while (!stack.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < stack.size() - 1; j++) {
                sb.append(" ");
            }
            sb.append("</");
            sb.append(stack.peek());
            sb.append(">");
            output.offer(String.valueOf(sb));
            stack.pop();
        }

        output.forEach(System.out::println);

    }
}
