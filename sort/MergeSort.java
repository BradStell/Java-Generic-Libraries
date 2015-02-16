package com.ultronicsystems.library.sort;

/**
 * Created by Ace on 1/31/15.
 */


public class MergeSort {

    /*
    public static int[] mergeSort(int [] list) {
        if (list.length <= 1) {
            return list;
        }

        // Split the array in half
        int[] leftArray = new int[list.length / 2];
        int[] rightArray = new int[list.length - leftArray.length];
        System.arraycopy(list, 0, leftArray, 0, leftArray.length);
        System.arraycopy(list, leftArray.length, rightArray, 0, rightArray.length);

        // Sort each half
        mergeSort(leftArray);
        mergeSort(rightArray);

        // Merge the halves together, overwriting the original array
        merge(leftArray, rightArray, list);
        return list;
    }

    private static void merge(int[] leftArray, int[] rightArray, int [] result) {
        // Merge both halves into the result array
        // Next element to consider in the first array
        int iLeft = 0;
        // Next element to consider in the second array
        int iRight = 0;

        // Next open position in the result
        int j = 0;
        // As long as neither iFirst nor iSecond is past the end, move the
        // smaller element into the result.
        while (iLeft < leftArray.length && iRight < rightArray.length) {
            if (leftArray[iLeft] < rightArray[iRight]) {
                result[j] = leftArray[iLeft];
                iLeft++;
            } else {
                result[j] = rightArray[iRight];
                iRight++;
            }
            j++;
        }
        // copy what's left
        System.arraycopy(leftArray, iLeft, result, j, leftArray.length - iLeft);
        System.arraycopy(rightArray, iRight, result, j, rightArray.length - iRight);
    }
    */


    public static void mergeSort(int[] array){

        int[] leftArray = new int[array.length/2];
        int[] rightArray = new int[array.length - leftArray.length];

        if(array.length != 1) {

            for (int i = 0; i < leftArray.length; i++) {
                leftArray[i] = array[i];
            }
            for (int i = 0; i < rightArray.length; i++) {
                rightArray[i] = array[i];
            }


            mergeSort(leftArray);
            mergeSort(rightArray);
            merge(array,leftArray,rightArray);
        }




    }

    public static void merge(int[] array, int[] left, int[] right){

        int iLeft = 0 , iRight = 0, i = 0;

        while(iLeft < left.length && iRight < right.length){
            if(left[iLeft] < right[iRight]){
                array[i] = left[iLeft];
                iLeft++;
            }else{
                array[i] = right[iRight];
                iRight++;
            }
            i++;
        }

        //TODO copy remaining.
        for (int l = 0; l < left.length - iLeft; l++) {
            array[i] = left[l];
        }
        for (int r = 0; r < right.length - iRight; r++) {
            array[i] = right[r];
        }


    }




}
