package telerik_preperation.mockExam5;

import java.util.Scanner;

public class Task01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long numberOfTargets = Long.parseLong(scanner.nextLine());
        long gSpeed = Long.parseLong(scanner.nextLine());
        long gLatency = Long.parseLong(scanner.nextLine());
        long pSpeed = Long.parseLong(scanner.nextLine());
        long pLatency = Long.parseLong(scanner.nextLine());

        long gSum = numberOfTargets*gSpeed + (gLatency*2);
        long pSum = numberOfTargets*pSpeed + (pLatency*2);

        if (gSum<pSum){
            System.out.println("George");
        } else if (pSum<gSum) {
            System.out.println("Peter");
        }else {
            System.out.println("Draw");
        }
    }
}