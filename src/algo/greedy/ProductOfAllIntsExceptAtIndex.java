package algo.greedy;

import java.util.Arrays;

/**
 * @author hasankagalwala on 4/29/20
 * @project algorithms
 *
 * Write a method getProductsOfAllIntsExceptAtIndex() that takes an array of integers and returns an array of the products.
 *
 * For example, given:
 *
 *   [1, 7, 3, 4]
 *
 * your method would return:
 *
 *   [84, 12, 28, 21]
 *
 * by calculating:
 *
 *   [7 * 3 * 4,  1 * 3 * 4,  1 * 7 * 4,  1 * 7 * 3]
 *
 */
public class ProductOfAllIntsExceptAtIndex {

    public static void main(String[] args) {
        int[] numbers = new int[] {1, 7, 3, 4};
        System.out.println(Arrays.toString(getProductsOfAllIntsExceptAtIndex1(numbers)));
        System.out.println(Arrays.toString(getProductsOfAllIntsExceptAtIndex2(numbers)));
    }

    //Solution 1
    //O(n) time and O(n) space where n is length of input array
    public static int[] getProductsOfAllIntsExceptAtIndex1(int[] array) {
        if (array.length < 2) {
            throw new IllegalArgumentException("Getting the product of numbers at other indices requires at least 2 numbers");
        }

        int[] products = new int[array.length];
        int[] leftProducts = new int[array.length];
        int[] rightProducts = new int[array.length];

        // For each integer, we find the product of all the integers before it, storing it separately
        int leftRunningProduct = 1;
        for(int i=0; i < array.length; i++) {
            leftProducts[i] = leftRunningProduct;
            leftRunningProduct *= array[i];
        }

        // For each integer, we find the product of all the integers after it, storing it separately
        int rightRunningProduct = 1;
        for (int i = array.length - 1; i >= 0; i--) {
            rightProducts[i] = rightRunningProduct;
            rightRunningProduct *= array[i];
        }

        //Now we combine the product of both leftRunning and rightRunning at respective indices
        for(int i=0; i < array.length; i++) {
            products[i] = leftProducts[i] * rightProducts[i];
        }
        return products;
    }


    //Solution 2
    //O(n) time and O(n) space where n is length of input array
    public static int[] getProductsOfAllIntsExceptAtIndex2(int[] array) {
        if (array.length < 2) {
            throw new IllegalArgumentException("Getting the product of numbers at other indices requires at least 2 numbers");
        }

        // We make an array with the length of the input array to hold our products
        int[] products = new int[array.length];

        // For each integer, we find the product of all the integers before it, storing the total product so far each time
        int productSoFar = 1;
        for (int i = 0; i < array.length; i++) {
            products[i] = productSoFar;
            productSoFar *= array[i];
        }

        // for each integer, we find the product of all the integers
        // after it. since each index in products already has the
        // product of all the integers before it, now we're storing
        // the total product of all other integers
        productSoFar = 1;
        for (int i = array.length - 1; i >= 0; i--) {
            products[i] *= productSoFar;
            productSoFar *= array[i];
        }

        return products;
    }

}
