package com.company;
import java.util.*;

public class SortDriver {

    /*
     * CREATE ARRAYS FUNCTION:
     * This function creates the 10 different arrays of doubles (with the correct sizes) and simultaneously
     * fills them with the appropriate amount of values.
     */
    public ArrayList<double[]> createArrays() {
        Random rand = new Random();
        ArrayList<double[]> storage = new ArrayList<double[]>();
        int size = 50000;
        for (int i = 0; i <= 10; i++) {
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
    public long[] calculateTime(double[] arr) {
        Selection selSort = new Selection();
        Bubble bubSort = new Bubble();
        Insertion inserSort = new Insertion();
        Merge merSort = new Merge();
        Quick qSort = new Quick();

        long[] storedTime = new long[5];
        long START = 0;
        long END = 0;
        Sort[] sortArray = {selSort, bubSort, inserSort, merSort, qSort};

        for (int i = 0; i < storedTime.length; i++) {
            double[] clonedArray = arr.clone();

            START = System.currentTimeMillis();
            sortArray[i].sort(clonedArray);
            END = System.currentTimeMillis();
            storedTime[i] = END - START;

            if (!isSorted(clonedArray)) {
                System.out.println("Current array (of size: " + clonedArray.length + ") not sorted... Leaving program.");
                System.exit(0);
            }
        }
        return storedTime;
    }

    /*
     * PRINT STATEMENTS FUNCTION:
     * This function prints out the statements the user will see at run time to give information
     * on how long each array took to be sorted after being passed through each sorting algorithm.
     */
    public static void printStatements (long[] longArr, int arrNum){
        String[] sortingNames = {"Selection Sort", "Bubble Sort", "Insertion Sort", "Merge Sort", "Quick Sort"};
        for (int i = 0; i < longArr.length; i++) {
            System.out.println("It took " + longArr[i] + "ms for " + sortingNames[i] + " to sort Array #" + arrNum);
        }
    }

    /*
     * isSORTED FUNCTION:
     * This function iterates through the entire array to determine if it is properly sorted.
     * Returns true or false, regarding whether it is sorted or not
     */
    public boolean isSorted (double[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            if (arr[i] > arr[i+1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        // STEP 1: create and fill the arrays using createArrays()
        double[] array1, array2, array3, array4, array5, array6, array7, array8, array9, array10;

        SortDriver sortDriverObj = new SortDriver();
        ArrayList<double[]> theTenArrays = sortDriverObj.createArrays();
        array1 = theTenArrays.get(0);
        array2 = theTenArrays.get(1);
        array3 = theTenArrays.get(2);
        array4 = theTenArrays.get(3);
        array5 = theTenArrays.get(4);
        array6 = theTenArrays.get(5);
        array7 = theTenArrays.get(6);
        array8 = theTenArrays.get(7);
        array9 = theTenArrays.get(8);
        array10 = theTenArrays.get(9);

        // STEP 2: pass the arrays through the sorting algorithms (use of array.clone())
        //         and log the time it takes to complete each sorting algorithm

        for (int i = 0; i < 10; i++) {
            long[] arrayTime = sortDriverObj.calculateTime(theTenArrays.get(i));
            printStatements(arrayTime, i+1);
            System.out.println();
        }
        
    }
}