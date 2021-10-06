package com.company;

import java.util.Arrays;
import java.util.Random;

public class Insertion implements Sort{

    // Insertion Sort Method/Function
    public void sort(double[] arr) {
        // iterate over entire array, starting at index 1, because first element is part of "sorted" section
        for (int i = 1; i < arr.length; i++) {
            double temp = arr[i]; // store the current element in a temp variable
            int j = i-1; // set j to the index/element before i
            // while the elements before the start of the "unsorted" portion are greater than the temp
            // move the elements over to the right
            while (j >= 0 && arr[j] > temp) {
                arr[j+1] = arr[j];
                --j;
            }
            // placing the first part of the "unsorted" portion in the right place
            // in the sorted portion
            arr[j+1] = temp;
        }
    }

    public static void main(String[] args) {
        Insertion test = new Insertion();
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
