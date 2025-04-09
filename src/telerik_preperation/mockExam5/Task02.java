package telerik_preperation.mockExam5;

import java.util.Scanner;

public class Task02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNum = Integer.parseInt(scanner.nextLine());
        int secondNum = Integer.parseInt(scanner.nextLine());
        int thirdNum = Integer.parseInt(scanner.nextLine());
        int fourthNum = Integer.parseInt(scanner.nextLine());
        int fifthNum = Integer.parseInt(scanner.nextLine());

        String output = "";
        int sumOne = (firstNum / 100) * (firstNum % 100 / 10) * (firstNum % 10);
        int sumTwo = (secondNum / 100) * (secondNum % 100 / 10) * (secondNum % 10);
        int sumTree = (thirdNum / 100) * (thirdNum % 100 / 10) * (thirdNum % 10);
        int sumFour = (fourthNum / 100) * (fourthNum % 100 / 10) * (fourthNum % 10);
        int sumFive = (fifthNum / 100) * (fifthNum % 100 / 10) * (fifthNum % 10);
        output += (sumOne % 10) + "" + (sumTwo % 10) + (sumTree % 10) + (sumFour % 10) + (sumFive % 10);
        System.out.println(output);
    }
}
