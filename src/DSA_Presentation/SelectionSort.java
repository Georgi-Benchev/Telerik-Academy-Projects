package DSA_Presentation;

import java.util.Random;


public class SelectionSort {

    public static void main(String[] args) {

        System.out.println();
        System.out.println();




        int[] randomNumbers = new int[10];
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            randomNumbers[i] = random.nextInt(0,20);
        }


        System.out.print("BEFORE SELECTION SORT -->  ");
        for (int i = 0; i < 10; i++) {
            System.out.print(randomNumbers[i]+" ");
        }
        System.out.println();


        selectionSort(randomNumbers);

        System.out.print("AFTER  SELECTION SORT -->  ");
        for (int i = 0; i < 10; i++) {
            System.out.print(randomNumbers[i]+" ");
        }

        System.out.println();
        System.out.println();
    }


    //  what is the code complexity?
    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            // Swap the found minimum element with the first element
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }
}