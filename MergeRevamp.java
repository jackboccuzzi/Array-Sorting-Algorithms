package com.company;
import java.util.*;

public class MergeRevamp implements Sort{

    /*
     * SORT REGIONS FUNCTION:
     * This function iterates through the array (with the help of findEndOfRegion()) and
     * returns an ArrayList of int Arrays containing the indexes of the sorted sub-arrays
     */
    private ArrayList<int[]> sortRegions(double[] arr) {
        ArrayList<int[]> theRegions = new ArrayList<int[]>();
        int startIndex = 0;
        int endIndex;
        while (startIndex < arr.length) {
            endIndex = findEndOfRegion(arr, startIndex);
            int[] subArrayRegion = {startIndex, endIndex};
            startIndex = endIndex + 1;
            theRegions.add(subArrayRegion);
        }
        return theRegions;
    }

    /*
     * FIND END OF REGION FUNCTION:
     * This function starts iterating from the start index passed as an argument
     * and stops whenever a value is greater than its previous. This returns the end index
     * and sends it back to sortRegions() so the index can be used.
     */
    private int findEndOfRegion(double[] arr, int start) {
        int end = start;
        // while end index is in-bounds and the region we are iterating over is sorted
        while (end < arr.length - 1 && arr[end] <= arr[end+1]) {
            end++;
        }
        return end;
    }

    // "Merge Sort" Function
    public void sort(double[] arr) {
        ArrayList<int[]> theSortedRegions = sortRegions(arr);

        while (theSortedRegions.size() > 1) {
            int getStartIndex = theSortedRegions.get(0)[0]; // start index of first sorted sub-array
            int getEndIndex = theSortedRegions.get(0)[1]; // end index of first sorted sub-array
            int getSecondStartIndex = theSortedRegions.get(1)[0]; // start index of second sorted sub-array
            int getSecondEndIndex = theSortedRegions.get(1)[1]; // end index of second sorted sub-array

            // endIndex + 1 because .copyOfRange() function not inclusive
            merge(arr, Arrays.copyOfRange(arr, getStartIndex, getEndIndex + 1), Arrays.copyOfRange(arr, getSecondStartIndex,  getSecondEndIndex + 1));
            int[] aSortedRegion = {theSortedRegions.get(0)[0], theSortedRegions.get(1)[1]};
            theSortedRegions.add(0, aSortedRegion);
            theSortedRegions.remove(2);
            theSortedRegions.remove(1);
        }

    }

    public void merge(double[] arr, double[] left, double[] right) {
        int arrIndex = 0;
        int rightIndex = 0;
        int leftIndex = 0;

        while (leftIndex < left.length && rightIndex < right.length) {
            if (left[leftIndex] < right[rightIndex]) {
                arr[arrIndex++] = left[leftIndex++];
            } else { // right[rightIndex] < left[leftIndex]
                arr[arrIndex++] = right[rightIndex++];
            }
        }
        while (leftIndex < left.length) {
            arr[arrIndex++] = left[leftIndex++];
        }
        while (rightIndex < right.length) {
            arr[arrIndex++] = right[rightIndex++];
        }
    }

    public String toString() {
        return "Revamped Merge";
    }

    public static void main(String[] args) {
        MergeRevamp mrObj = new MergeRevamp();
        double[] testArr = {31.0, 60.0, 80.0, 76.0, 16.0, 79.0, 47.0, 47.0, 23.0, 67.0};

        // Expected: [0,2] [3,3] [4,5] [6,7] [8,9]
        ArrayList<int[]> returnArray = mrObj.sortRegions(testArr);

        mrObj.sort(testArr);
        System.out.println("The REVAMPED Merge Sort: ");
        System.out.println(Arrays.toString(testArr));

    }

}
