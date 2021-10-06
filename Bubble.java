package com.company;
import java.util.*;

public class Bubble implements Sort {

    // Swap Helper Function
    public void swap(double[] arr, int index1, int index2) {
        double temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    // Bubble Sort Method/Function
    public void sort(double[] arr) {
        // allows us to continuously loop through the array "n" times (n = length of the array)
        for (int i = 0; i < arr.length; i++) {
            // iterates through the entire array, comparing adjacent values and swapping if needed
            for (int j = 0; j < arr.length-1; j++) {
                // if one value is greater than the next one, swap it
                if (arr[j] > arr[j+1]) {
                    swap(arr, j, j+1);
                }
            }
        }
    }

    public static void main(String[] args) {
        Bubble test = new Bubble();
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