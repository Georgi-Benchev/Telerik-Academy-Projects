package telerik_preperation.examTelerikAcademyAugust2024;

import java.util.Scanner;

public class Task01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String bestInputName = "";
        int bestDif = Integer.MAX_VALUE;
        int bestPrice = Integer.MAX_VALUE;
        boolean check = false;

        for (int ppp = 0; ppp < n; ppp++) {

            String[] input = scanner.nextLine().split(" ");
            int priceTemp = Integer.parseInt(input[1]);
            int timesTemp = Integer.parseInt(input[2]);
            int differance = timesTemp - priceTemp;

            if (differance >= 0) {
                if (bestDif > differance) {
                    bestInputName = input[0];
                    bestDif = differance;
                    bestPrice = priceTemp;
                    check = true;
                } else if (bestDif == differance && bestPrice > priceTemp) {
                    bestDif = differance;
                    bestPrice = priceTemp;
                    check = true;
                }
            }
        }

        if (check){
            System.out.println(bestInputName);
        }

    }
}
