/**
 * Created by B-rad on 3/6/2015.
 */
public class SortingAlgo {

    public static <T extends Comparable<T>> void quickSort(T[] array) {
        if (array.length < 2)
            return;
        quickSort(array, 0, array.length - 1);
    }


    private static <T extends Comparable<T>> void quickSort(T[] array, int lo, int hi) {

        // fewer than 2 items
        if (hi - lo <= 0) {
            return;
        }

        int splitPoint = partition(array, lo, hi);
        quickSort(array, lo, splitPoint - 1); // Left Sub array recursion
        quickSort(array, splitPoint + 1, hi); // right sub array recursion
    }

    private static <T extends Comparable<T>> int partition(T[] array, int lo, int hi) {

        int left = lo + 1;
        int right = hi;
        T pivot = array[lo];

        while (true) {
            while (left <= right) {
                if (array[left].compareTo(pivot) < 0) {
                    left++;
                } else {
                    break;
                }
            }

            while (right > left) {
                if (array[right].compareTo(pivot) < 0) {
                    break;
                } else {
                    right--;
                }
            }

            if (left >= right) {
                break;
            }

            // swap left and right items
            T temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            //advance each one step
            left++;
            right--;
        }

        // swap pivot with left - 1
        array[lo] = array[left - 1];
        array[left-1] = pivot;

        // return splitPoint
        return left - 1;
    }
}
