package telerik_preperation.mockExam5;

import java.util.Arrays;
import java.util.Scanner;

public class Task03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int spawnPoints = Integer.parseInt(scanner.nextLine());
        int[] safeHouses = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Arrays.sort(safeHouses);
        int bestDist = 0;
        for (int i = 0; i < safeHouses.length - 1; i++) {
            if ((safeHouses[i + 1] - safeHouses[i]) / 2 > bestDist) {
                bestDist = (safeHouses[i + 1] - safeHouses[i]) / 2;
            }
        }
        if (safeHouses[0] > bestDist) {
            bestDist = safeHouses[0];
        }
        int lastHouse = safeHouses[safeHouses.length - 1];
        if (spawnPoints - 1 - lastHouse > bestDist) {
            bestDist = (spawnPoints - 1 - lastHouse);
        }
        System.out.println(bestDist);

    }
}