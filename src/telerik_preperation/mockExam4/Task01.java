package telerik_preperation.mockExam4;

import java.util.Scanner;

public class Task01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int smallBottles = Integer.parseInt(scanner.nextLine());
        int bigBottles = Integer.parseInt(scanner.nextLine()) * 5;
        int capacity = Integer.parseInt(scanner.nextLine());

        if (bigBottles + smallBottles < capacity) {
            System.out.println("-1");
        } else if (bigBottles == capacity) {
            System.out.println("0");
        } else {
            if (bigBottles > capacity) {
                int check = capacity % 5;
                if (check<=smallBottles){
                    System.out.println(check);
                }else {
                    System.out.println("-1");
                }
            }else {
                System.out.println(capacity-bigBottles);

            }
        }

    }
}
