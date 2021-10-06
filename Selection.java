package com.company;
import java.util.*;

public class Selection implements Sort{

    // Swap helper function
    public void swap(double[] arr, int index1, int index2) {
        double temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    // Selection Sort Function/Method
    public void sort(double[] arr) {
        for (int i = 0; i < arr.length; i++) {
            // nested-loop loops through the entire array, comparing rest of values to current smallest
            // and changes the smallest if a smaller value is found
            // helps us look through list after index i (the unsorted portion)
            int smallestIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[smallestIndex]) {
                    smallestIndex = j;
                }
            }
            swap(arr, i, smallestIndex);
        }
    }

    public static void main(String[] args) {
        //code
        Selection test = new Selection();
        Random rand = new Random();

        double[] myArray = new double[5];
        for (int i = 0; i < myArray.length; i++) {
            myArray[i] = rand.nextDouble();
        }

        System.out.println("Unsorted Array: " + Arrays.toString(myArray));
        test.sort(myArray);
        System.out.println("Sorted Array: " + Arrays.toString(myArray));

    }
}
