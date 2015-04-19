public class MyCountingSort {
	/*************************************************************************************************************
     * Counting Sort
     * @param arr
     */
    public static void countingSort(int[] arr) {
        int maxValue = getMaxValue(arr);
        int[] frequency = new int[maxValue + 1];
        int[] temp = new int[arr.length];

        // Initiation Loop: Not needed in java because the variable declaration actually initializes the array with all 0's.
        // However I am explicitly doing this for demonstration purposes.
        for(int i = 0; i < frequency.length; i++)
            frequency[i] = 0;

        // Frequency Loop
        // Get the frequency of the values in the array
        for(int i = 0; i < arr.length; i++)
            frequency[arr[i]]++;

        // Loop through the frequency array, as we come to a value that was in the original array (not 0)
        // then put that number (i) into the temp array for the specified amount of times (the value in the frequency array position).
        int count = 0;
        for (int i = 0; i < frequency.length; i++) {
            int num = frequency[i];
            if (num > 0) {
                for (int j = 0; j < num; j++) {
                    temp[count] = i;
                    count++;
                }
            }
        }

        // This loop makes it seem like an "in place" sorting algorithm.
        // It reassembles the sent in array giving the perception that the sent in array gets sorted in place.
        for(int i = 0; i < arr.length; i++)
            arr[i] = temp[i];
    }

    /**
     * Returns the max value of the incoming array
     * @param arr
     * @return
     */
    private static int getMaxValue(int[] arr) {
        int max = arr[0];

        for(int i = 0; i < arr.length; i++) {
            if(arr[i] > max)
                max = arr[i];
        }
        return max;
    }
    /************************************************************************************************************/
}