package codingTasks.tasks_02;

import java.util.Scanner;

public class Task01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String output = "";

        for (int i = 1; i <= n; i++) {
            if (isItPrime(i)){
                output+="1";
                System.out.println(output);
            }else {
                output+="0";
            }
        }
    }

    public static boolean isItPrime(int number) {
        boolean check = true;

        for (int i = 2; i < number; i++) {
            if (number%i==0){
                check=false;
                break;
            }
        }
        return check;
    }
}