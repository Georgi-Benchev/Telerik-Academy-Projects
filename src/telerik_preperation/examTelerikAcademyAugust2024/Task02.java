package telerik_preperation.examTelerikAcademyAugust2024;

import java.util.Arrays;
import java.util.Scanner;

public class Task02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int rowsCount = 0;
        int beers = 0;
        int party = 0;
        int project = 0;
        int dsa = 0;
        boolean check = false;

        for (int i : numbers) {
            rowsCount++;
            if (i == 0) {
                beers++;
                if (beers == 3) {
                    check = true;
                    break;
                }
            } else if (i == 1) {
                party++;
                if (party == 3) {
                    check = true;
                    break;
                }
            } else if (i == 2) {
                project++;
                if (project == 3) {
                    check = true;
                    break;
                }
            } else if (i == 3) {
                dsa++;
                if (dsa == 3) {
                    check = true;
                    break;
                }
            }
        }

        if (check) {
            if (beers == 3) {
                System.out.println(rowsCount + ": Beers!");
            } else if (party == 3) {
                System.out.println(rowsCount + ": Party");
            } else if (project == 3) {
                System.out.println(rowsCount + ": Work on the project");
            } else if (dsa == 3) {
                System.out.println(rowsCount + ": May the DSA Force be with you!");
            }
        }

    }
}