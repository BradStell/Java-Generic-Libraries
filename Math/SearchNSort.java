/**
 * Created by Brad on 2/24/2015.
 */
public class SearchNSort {

    /**
     *
     * @param array
     * @param search
     * @return
     */
    public static Integer exhaustiveSearch(int array[], int search) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == search)
                return array[i];
        }
        return null;
    }

    /**
     *
     * @param n
     */
    public static void printBinaryNumsOfLength(int n) {
        String B;
        int temp;
        for(int i = 0; i < Math.pow(2,n); i++) {
            B = "";
            temp = i;
            for (int j = 0; j < n; j++) {
                if (temp%2 == 1)
                    B += '1';
                else
                    B += '0';
                temp /= 2;
            }
            System.out.println(B);
        }
    }

    /**
     *
     * @param arr
     * @return
     */
    public static int[] selectionSort(int arr[]) {
        int ind;
        int temp;
        for (int i = 0; i < arr.length; i++) {
            ind = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[ind])
                    ind = j;
            }
            temp = arr[i];
            arr[i] = arr[ind];
            arr[ind] = temp;
        }
        return arr;
    }

    /**
     *
     * @param arr
     * @return
     */
    public static int[] bubbleSort(int arr[]) {

        boolean sorted = false;
        int temp;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    sorted = false;
                }
            }
        }
        return arr;
    }

    /**
     *
     *
     */
    private static void permutation(String prefix, String str) {
        int n = str.length();
        if (n == 0)
            System.out.println(prefix);
        else {
            for (int i = 0; i < n; i++)
                permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
        }
    }

    /**
     *
     *
     */
    static void permutation(List<Integer> arr, int k){
        for(int i = k; i < arr.size(); i++){
            Collections.swap(arr, i, k);
            permute(arr, k+1);
            Collections.swap(arr, k, i);
        }
        if (k == arr.size() -1){
            System.out.println(Arrays.toString(arr.toArray()));
        }
    }

    /**
     *
     *
     */
    static void permutation(int[] arr, int k) {
        for(int i = k; i < arr.length; i++){
            int temp = arr[i];
            arr[i] = arr[k];
            arr[k] = temp;

            permperm(arr, k + 1);

            temp = arr[k];
            arr[k] = arr[i];
            arr[i] = temp;
        }
        if (k == arr.length -1){
            for ( int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.print("\n");
        }
    }
}
