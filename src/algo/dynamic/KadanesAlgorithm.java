package algo.dynamic;

/**
 * @author hasankagalwala on 10/17/20
 * @project algorithms
 *
 * Find the sum of contiguous subarray within a one-dimensional array of numbers which has the largest sum.
 * Example:
 * Input: [3, 5, -9, 1, 3, -2, 3, 4, 7, 2, -9, 6, 3, 1, -5, 4]
 * Output: 19 // [1, 3, -2, 3, 4, 7, 2, -9, 6, 3, 1]
 */
public class KadanesAlgorithm {

    public static int kadanesAlgorithm(int[] array) {
        int maxEndingHere = array[0];
        int maxSoFar = array[0];
        for(int i=1; i < array.length; i++) {
            int num = array[i];
            maxEndingHere = Math.max(num, maxEndingHere + num);
            //System.out.println("maxEndingHere: "+maxEndingHere);
            maxSoFar= Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
    }

    public static void main(String[] args) {
        int[] arr = {3, 5, -9, 1, 3, -2, 3, 4, 7, 2, -9, 6, 3, 1, -5, 4};
        System.out.println(kadanesAlgorithm(arr));
    }
}
