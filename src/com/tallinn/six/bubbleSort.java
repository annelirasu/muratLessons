package com.tallinn.six;

import java.util.Arrays;

public class bubbleSort {


    public static void main(String[] args) {
        int numberArray[] = {6, 5, 3, 1, 8, 7, 2, 4};
        System.out.println("Array before bubble sort");
        System.out.println(Arrays.toString((numberArray)));
        System.out.println();

        bubbleSort(numberArray);
        System.out.println("Array after bubble sort");
        System.out.println(Arrays.toString((numberArray)));
    }

    public static void bubbleSort(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
    }
}

