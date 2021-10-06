package com.company;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class MergeDriver {

    /*
     * CREATE ARRAYS FUNCTION:
     * This function creates the 10 different arrays of doubles (with the correct sizes) and simultaneously
     * fills them with the appropriate amount of values.
     */
    public ArrayList<double[]> createArrays() {
        Random rand = new Random();
        ArrayList<double[]> storage = new ArrayList<double[]>();
        int size = 50000;
        for (int i = 0; i < 10; i++) {
            double[] array = new double[size];
            for (int j = 0; j < array.length; j++) {
                array[j] = rand.nextDouble();
            }
            storage.add(array);
            size += 50000; // increase size of array by 50000
        }
        return storage;
    }

    /*
     * CALCULATE TIME FUNCTION:
     * This function returns an array of long values. These long values represent the time it took
     * for each sorting algorithm to sort the array passed as an argument.
     */
    public long[] calculateTime (double[] arr) {
        Merge originalMerge = new Merge();
        MergeRevamp customMerge = new MergeRevamp();
        Sort[] sortingMethods = {originalMerge, customMerge};
        long[] storageForTimes = new long[2];
        long start = 0;
        long end = 0;

        for (int i = 0; i < storageForTimes.length; i++) {
            double[] copiedArray = arr.clone();

            start = System.currentTimeMillis();
            sortingMethods[i].sort(copiedArray);
            end = System.currentTimeMillis();
            storageForTimes[i] = end - start;

            // check if sorted
            if (!isArraySorted(copiedArray)) {
                System.out.println("The array going through " + sortingMethods[i] + " sorting algorithm. The array is not sorted. Leaving Program.");
                System.exit(0);
            }
        }
        return storageForTimes;
    }

    /*
     * isArraySORTED FUNCTION:
     * This function iterates through the entire array to determine if it is properly sorted.
     * Returns true or false, regarding whether it is sorted or not
     */
    public boolean isArraySorted(double[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            if (arr[i] > arr[i+1]) {
                return false;
            }
        }
        return true;
    }

    /*
     * PRINT STATEMENTS FUNCTION:
     * This function prints out the statements the user will see at run time to give information
     * on how long each array took to be sorted after being passed through each sorting algorithm.
     */
    public static void printStatements (long[] longArr, int arrNum){
        String[] sortingNames = {"Merge Sort", "Revamped Merge Sort"};
        for (int i = 0; i < longArr.length; i++) {
            System.out.println("It took " + longArr[i] + "ms for " + sortingNames[i] + " to sort Array #" + arrNum);
        }
    }

    public static void main(String[] args) {
        MergeDriver mainObj = new MergeDriver();

        // create the arrays
        ArrayList<double[]> TenArrays = mainObj.createArrays();


        for (int i = 0; i < TenArrays.size(); i++) {
            long[] arrayTime = mainObj.calculateTime(TenArrays.get(i));
            printStatements(arrayTime, i+1);
            System.out.println();
        }
    }
}
