package linearCodingTasks_Stack_Queue;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Task2_withNode {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfStudents = scanner.nextInt();
        int numberOfChanges = scanner.nextInt();
        scanner.nextLine();

        String[] students = scanner.nextLine().split(" ");


        Map<String, Node> studentMap = new HashMap<>();
        Node head = new Node(students[0]);
        studentMap.put(students[0], head);
        Node currentNode = head;


        for (int i = 1; i < numberOfStudents; i++) {
            Node newNode = new Node(students[i]);
            studentMap.put(students[i], newNode);
            currentNode.next = newNode;
            newNode.prev = currentNode;
            currentNode = newNode;
        }


        for (int i = 0; i < numberOfChanges; i++) {
            String studentToMove = scanner.next();
            String studentToMoveLeftOf = scanner.next();

            Node nodeToMove = studentMap.get(studentToMove);
            Node nodeToMoveLeftOf = studentMap.get(studentToMoveLeftOf);

            if (nodeToMoveLeftOf == head) {
                head = nodeToMove;
            } else if (nodeToMove == head) {
                if (nodeToMoveLeftOf != nodeToMove.next) {
                    head = nodeToMove.next;
                }
            }


            if (nodeToMove.prev != null) {
                nodeToMove.prev.next = nodeToMove.next;
            }
            if (nodeToMove.next != null) {
                nodeToMove.next.prev = nodeToMove.prev;
            }

            nodeToMove.next = nodeToMoveLeftOf;
            nodeToMove.prev = nodeToMoveLeftOf.prev;

            if (nodeToMoveLeftOf.prev != null) {
                nodeToMoveLeftOf.prev.next = nodeToMove;
            }
            nodeToMoveLeftOf.prev = nodeToMove;


        }


        StringBuilder result = new StringBuilder();
        Node current = head;
        while (current != null) {
            result.append(current.name).append(" ");
            current = current.next;
        }

        System.out.println(result);
    }
    
    public static class Node {
        String name;
        Node next;
        Node prev;

        Node(String name) {
            this.name = name;
            this.prev = null;
            this.next = null;
        }
    }

}
