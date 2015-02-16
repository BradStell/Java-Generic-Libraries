package com.ultronicsystems.library.search;

/**
 * Created by Ace on 2/3/15.
 */
public class BinarySearch {

    public static int binarySearch(int[] array, int itemToFind){

            int leftIndex = 0;
            int rightIndex = array.length - 1;
            while (leftIndex <= rightIndex) {
                // Calculate the midpont, calculate the midpoint and then offset it by the leftIndex
                int mid = leftIndex + (rightIndex - leftIndex) / 2;

                if (itemToFind < array[mid]){
                    rightIndex = mid - 1;
                }
                else if(itemToFind > array[mid]){
                    leftIndex = mid + 1;
                }
                else{
                    return mid;
                }
            }
            //Not Found Code
            return -1;
    }






}
