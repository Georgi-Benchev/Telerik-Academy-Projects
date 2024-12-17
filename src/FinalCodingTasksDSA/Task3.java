package FinalCodingTasksDSA;

import java.util.*;

public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> queue = new ArrayList<>();
        Map<String, Integer> membersCounter = new HashMap<>();
        int pointerStart = 0;
        int pointerEnd = 0;


        String input;
        while (!"End".equals(input = scanner.nextLine())) {
            String[] commandsArr = input.split(" ");
            String command = commandsArr[0];
            String param2 = commandsArr[1];

            switch (command) {
                case "Append": {
                    addNameToMap(membersCounter, param2);
                    queue.add(param2);
                    pointerEnd++;
                    System.out.println("OK");
                    break;
                }// 1 3 5 6 9   start 2 end 5
                case "Insert": {
                    int pos = Integer.parseInt(param2);
                    int size = pointerEnd - pointerStart;
                    if (pos >= 0 && pos <= size) {
                        String name = commandsArr[2];
                        addNameToMap(membersCounter, name);

                        if (pos == size) {
                            queue.add(name);
                        } else {
                            queue.add(pointerStart + pos, name);
                        }
                        pointerEnd++;
                        System.out.println("OK");
                    } else {
                        System.out.println("Error");
                    }

                    break;
                }
                case "Find": {
                    if (membersCounter.containsKey(param2)) {
                        System.out.println(membersCounter.get(param2));
                    } else {
                        System.out.println("0");
                    }
                    break;
                }
                case "Examine": {
                    int count = Integer.parseInt(param2);
                    int size = pointerEnd - pointerStart;
                    if (count > 0 && count <= size) {
                        StringBuilder output = new StringBuilder();

                        for (int i = 0; i < count; i++) {
                            output.append(queue.get(pointerStart)).append(" ");
                            removeNameFromMap(membersCounter, queue.get(pointerStart));
                            pointerStart++;
                        }

                        System.out.println(output.substring(0, output.length() - 1));
                    } else {
                        System.out.println("Error");
                    }
                    break;
                }
            }
        }
    }

    private static void removeNameFromMap(Map<String, Integer> membersCounter, String name) {
        if (membersCounter.get(name) == 1) {
            membersCounter.remove(name);
        } else {
            membersCounter.put(name, membersCounter.get(name) - 1);
        }
    }

    private static void addNameToMap(Map<String, Integer> membersCounter, String name) {
        if (membersCounter.containsKey(name)) {
            membersCounter.put(name, membersCounter.get(name) + 1);
        } else {
            membersCounter.put(name, 1);
        }
    }
}
