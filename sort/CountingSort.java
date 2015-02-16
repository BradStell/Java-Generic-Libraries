package com.ultronicsystems.library.sort;

/**
 * Created by Ace on 2/3/15.
 */
public class CountingSort {

    //This method has been optimized so it can be called statically and does not need to store the results.

    public static void countingSort(int[] intArray){
        int maxValue = getMaxValue(intArray);
        int [] frequency = new int[maxValue + 1];
        int [] temp = new int[intArray.length];

        //Initiation Loop
        for(int i=0;i<frequency.length;i++){
            frequency[i] = 0;
        }

        //Frequency Loop
        for(int i=0;i<intArray.length;i++){
            frequency[intArray[i]]++;
        }

        //Loop through the frequency array and update the values to display how many slots are needed for each.
        //Increase the value by the indices behind it.
        for(int i=1;i<frequency.length;i++){
            frequency[i] += frequency[i-1];
        }

        for(int i=intArray.length-1;i>=0;i--){
            //-1 is to account for temp max index being 1 less than frequency.
            //-- Decrements the freqeuncy down to account for one being removed.
            temp[frequency[intArray[i]]-- - 1] = intArray[i];
        }


        //This loop allows static calling by reference.
        for(int i=0;i<intArray.length;i++){
            intArray[i] = temp[i];
        }


    }

    public static void countingSortNegEnabled(int[] intArray){
        //Obtain the max to create a key.
        int maxValue = getMaxValue(intArray);
        //Obtain the minimum as an offset to move the key ranges into the positive values
        int minValue = getMinValue(intArray);

        int [] frequency = new int[maxValue - minValue + 1];
        int [] temp = new int[intArray.length];

        //Initiation Loop
        for(int i=0;i<frequency.length;i++){
            frequency[i] = 0;
        }

        //Frequency Loop
        for(int i=0;i<intArray.length;i++){
            //Apply the offset for negatives with minValue
            frequency[intArray[i] - minValue]++;
        }

        //Loop through the frequency array and update the values to display how many slots are needed for each.
        //Increase the value by the indices behind it.
        for(int i=1;i<frequency.length;i++){
            frequency[i] += frequency[i-1];
        }

        for(int i=intArray.length-1;i>=0;i--){
            //-1 is to account for temp max index being 1 less than frequency.
            //-- Decrements the freqeuncy down to account for one being removed.
            //Apply the offset for negatives with minValue
            temp[frequency[intArray[i] - minValue]-- - 1] = intArray[i];
        }


        //This loop allows static calling by reference.
        for(int i=0;i<intArray.length;i++){
            intArray[i] = temp[i];
        }


    }




    private static int getMaxValue(int[] array){
        int max = array[0];

        for(int i=0;i<array.length;i++){
            if(array[i] > max){
                max = array[i];
            }
        }

        System.out.println("Max Value: " + max);
        return max;
    }

    private static int getMinValue(int[] array){
        int min = array[0];

        for(int i=0;i<array.length;i++){
            if(array[i] < min){
                min = array[i];
            }
        }

        System.out.println("Min Value: " + min);
        return min;
    }





}
