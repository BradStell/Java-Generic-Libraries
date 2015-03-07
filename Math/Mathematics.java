/**
 * Created by Brad on 2/24/2015.
 */
public class Mathematics {

    /**
     *
     * @param array
     * @return
     */
    public static int maximum(int array[]) {
        int ind = 0;
        int i = 1;
        while (i < array.length) {
            if (array[i] > array[ind]) {
                ind = i;
            }
            i++;
        }
        return array[ind];
    }

    /**
     *
     * @param n
     * @return
     */
    public static boolean prime(int n) {
        int i = 2;
        while (i < n) {
            if (n % i == 0) {
                return false;
            }
            i++;
        }
        return true;
    }

    /**
     *
     * @param A
     * @param B
     * @return
     */
    public static int[][] matrixMultiply(int A[][], int B[][]) {
        int C[][] = new int[A.length][A.length];

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                C[i][j] = 0;
                for (int k = 0; k < A.length; k++) {
                    C[i][j] += A[i][k] * B[k][j];
                }
            }
        }

        return C;
    }

    /**
     *
     * @param n
     * @return
     */
    public static long factorial(long n) {
        if (n == 0 || n == 1)
            return 1;
        else
            return n * factorial(n - 1);
    }



}
