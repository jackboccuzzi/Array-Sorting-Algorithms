package com.company;
import java.util.Arrays;
import java.util.Random;

public class Quick implements Sort {
    public void swap(double[] arr, int index1, int index2) {
        double temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    public int partition (double[] arr, int left, int right) {
        double pivot = arr[right]; // pivot is last element in list
        int index = (left - 1);

        for (int j = left; j < right; j++) {
            if (arr[j] <= pivot) {
                index++;
                swap(arr, index, j);
            }
        }
        swap(arr, index + 1, right);

        return index+1;
    }

    public void quicksort (double [] arr, int left, int right) {
        if (left < right) {
            int p = partition(arr, left, right);

            quicksort(arr, left, p - 1); // All values in left are <= arr[p]
            quicksort(arr, p + 1, right);
        }
    }

    public void sort(double[] arr) {
        quicksort(arr, 0, arr.length-1);
    }

    public String toString() {
        return "Quick Sort";
    }

    public static void main(String[] args) {
        Quick test = new Quick();
        Random rand = new Random();

        double[] myArray = new double[5];
        for (int i = 0; i < myArray.length; i++) {
            myArray[i] = rand.nextDouble();
        }

        System.out.println("Unsorted Array: " + Arrays.toString(myArray));
        test.quicksort(myArray, 0, myArray.length-1);
        System.out.println("Sorted Array: " + Arrays.toString(myArray));

    }
}
