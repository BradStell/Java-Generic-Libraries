package com.ultronicsystems.library.sort;

/**
 * Created by Ace on 1/31/15.
 */


public class QuickSort {


    public static int[] quickSort(int[] data, int first, int last){

        if(first < last){
            //Partition the data to obtain pivot
            int pivot = partition(data, first, last);
            //Sort the Left Side
            quickSort(data,first,pivot-1);
            //Sort the Right Side
            quickSort(data,pivot+1,last);
        }


        return data;
    }


    private static int partition(int[] data, int first, int last){

        //Set the pivot to the last element
        int pivot = data[last];
        int temp;

        int i = first - 1;

        for(int j = first; j<last; j++){

            //Find values smaller than pivot and swapping them behind the pivot. Work on dat explan.
            if(data[j] <= pivot){
                i++;

                //Swap data[i] and data[j]
                temp = data[j];
                data[j] = data[i];
                data[i] = temp;
            }
        }

        //Swap the pivot with the last remaining larger number.
        temp = data[i+1];
        data[i+1] = data[last];
        data[last] = temp;


        return i+1;
    }




    public static <U extends Comparable<U>> void genericQuicksort(U[] array){

        if (array == null) {
            throw new
                    IllegalArgumentException("Input Array cannot be null");
        }
        int length = array.length;
        if (length == 1) return;
        genericQuicksort(array, 0, length - 1);

    }

    private static <U extends Comparable<U>> void genericQuicksort(U[] array, int left, int right) {

        //Base case
        if (left >= right) return;

        //Choose the pivot using median of 3 partitioning
        //using the following 2 steps
        //First step: find the center
        int center = (left+right)/2;
        //Second step: sort left, center and right
        if (array[left].compareTo(array[center]) > 0) {
            swap(array, left, center);
        }
        if (array[left].compareTo(array[right]) > 0) {
            swap(array, left, right);
        }
        if (array[center].compareTo(array[right]) > 0) {
            swap(array, center, right);
        }
        //Third Step:
        //Got the pivot and it is at the center.
        //Move it to the end of the array.
        swap(array,center,right-1);
        int pivot = right-1;

        //Partition the array
        int i = left,j = right - 2;
        if (j >= 0) {
            for(;;) {
                while (array[i].compareTo(array[pivot])< 0) {
                    i++;
                }
                while(array[j].compareTo(array[pivot]) > 0) {
                    j--;
                }
                if (i >= j) break;
                swap(array,i,j);
            }
        }
        //Put the pivot at ith position of the array
        swap(array,i,right-1);
        //Now all the elements to the right of i are less than
        //it and all the elements to the left of i are greater
        //than it. So partition the array and
        //recursively call quicksort on the left and right partition
        genericQuicksort(array, left, i - 1);
        genericQuicksort(array, i+1, right);

    }

    /**
     * Internal method to swap to elements in an array.
     * @param a an array of objects.
     * @param left the index of the first object.
     * @param right the index of the second object.
     */
    private static <T extends Comparable<T>>
    void swap(T[] a, int left, int right) {
        T temp = a[left];
        a[left] = a[right];
        a[right] = temp;
    }








}
