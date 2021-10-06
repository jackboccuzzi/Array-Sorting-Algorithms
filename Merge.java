package com.company;
import java.util.*;

public class Merge implements Sort{

    public double[] get_left (double[] arr) {
        int size = arr.length/2;
        double[] left = new double[size];
        for (int i = 0; i < size; i++) {
            left[i] = arr[i];
        }
        return left;
    }

    public double[] get_right (double[] arr) {
        int size = arr.length - arr.length/2;
        double[] right = new double[size];

        // If the array has an even amount of elements...
        if (arr.length % 2 == 0) {
            for (int i = size; i < arr.length; i++) {
                right[i - size] = arr[i];
            }
        }
        // If the array has an odd number of elements...
        else {
            for (int i = size - 1; i < arr.length; i++) {
                right[i - size + 1] = arr[i];
            }
        }
        return right;
    }

    public void merge(double[] arr, double[] left, double[] right) {
        int arrIndex = 0;
        int rightIndex = 0;
        int leftIndex = 0;

        while (arrIndex < arr.length) {
            // if you run out of elements in the left array, copy the remaining values
            // from the right array over to the main array
            if (leftIndex == left.length) {
                arr[arrIndex++] = right[rightIndex++];
            }
            // if you run out of elements in the right array, copy the remaining values
            // from the left array over to the main array
            else if (rightIndex == right.length) {
                arr[arrIndex++] = left[leftIndex++];
            }
            // compare whether the left value < right value at the current index and which ever
            // is less than, add it to the main array
            else if (left[leftIndex] < right[rightIndex]) {
                arr[arrIndex++] = left[leftIndex++];
            }
            else { // right[rightIndex] < left[leftIndex]
                arr[arrIndex++] = right[rightIndex++];
            }
        }
    }

    // Merge Sort Function/Method
    public void sort(double[] arr) {
        if (arr.length > 1) {
            double[] left = get_left(arr);
            double[] right = get_right(arr);

            sort(left);
            sort(right);

            merge(arr, left, right);
        }
    }

    public String toString() {
        return "Merge Sort";
    }

    public static void main(String[] args) {
        Merge test = new Merge();
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
