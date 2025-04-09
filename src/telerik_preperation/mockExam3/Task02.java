package telerik_preperation.mockExam3;

import java.util.Arrays;
import java.util.Scanner;

public class Task02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] firstInput = Arrays.stream(scanner.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        int[] secondInput = Arrays.stream(scanner.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        int[] output = new int[firstInput.length];
        for (int i = 0; i < output.length; i++) {
            output[i] = -1;
        }


        for (int i = 0; i < firstInput.length; i++) {
            int item = firstInput[i];
            for (int j = 0; j < secondInput.length - 1; j++) {
                if (item == secondInput[j]) {
                    for (int k = j + 1; k < secondInput.length; k++) {
                        if (item < secondInput[k]) {
                            output[i] = secondInput[k];
                            break;
                        }
                    }
                }
            }
        }

        String print = "";
        for (int i = 0; i < output.length - 1; i++) {
            print += output[i] + ",";
        }

        System.out.println(print + output[output.length - 1]);
    }
}
