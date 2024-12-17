package DSA.DSA_Presentation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BogoSort {
    public static void main(String[] args) {

/*
        List<Integer> numbers = new ArrayList<>(List.of(1,2,3,4,5));
*/
        List<Integer> numbers = new ArrayList<>(List.of(1,2,3,4,5,6,7,8,9,10));

        /*List<Integer> numbersSorted = new ArrayList<>(List.of(1,2,3,4,5));*/
        List<Integer> numbersSorted = new ArrayList<>(List.of(1,2,3,4,5,6,7,8,9,10));
        Collections.shuffle(numbers);
        int count = 1;


        while (!numbers.equals(numbersSorted)){
            System.out.println(count++);
            Collections.shuffle(numbers);
        }
    }
}
