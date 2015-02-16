package com.ultronicsystems.library.search;

import com.ultronicsystems.library.sort.CountingSort;

/**
 * Created by Alexander on 2/4/2015.
 */
public class IntegersInRange {


    public static int integersInRange(int[] array, int start, int end){
        int count = 0;

        CountingSort.countingSortNegEnabled(array);

        for(int i=0;i<array.length;i++){
            if(array[i] >= start && array[i] <= end){
                count++;
            }
        }



        for(int i=0;i<array.length;i++){
            System.out.print(array[i] + " ");
        }
        System.out.println("Numbers in range " + start + " to " + end + "  = " + count);


        return count;
    }


}
