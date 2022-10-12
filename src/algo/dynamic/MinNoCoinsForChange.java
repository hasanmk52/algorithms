package algo.dynamic;

import java.util.Arrays;

/**
 * @author hasankagalwala on 31/08/2021
 * @project algorithms
 *
 * Given a set of coins and a total money amount. Write a method to compute the
 * smallest number of coins to make up the given amount.
 * If the amount cannot be made up by any combination of the given coins, return -1.
 *
 * For example:
 * Given [2, 5, 10] and amount=6, the method should return -1.
 * Given [1, 2, 5] and amount=7, the method should return 2.
 */
public class MinNoCoinsForChange {

    public static int minNumberOfCoinsForChange(int n, int[] denoms) {
        int[] noOfCoins = new int[n + 1];
        Arrays.fill(noOfCoins, Integer.MAX_VALUE);
        noOfCoins[0] = 0;
        int toCompare = 0;
        for(int denom : denoms) {
            for(int amount = 0; amount < noOfCoins.length; amount++) {
                if(denom <= amount) {
                    if(noOfCoins[amount - denom] == Integer.MAX_VALUE) {
                        toCompare = noOfCoins[amount - denom];
                    } else {
                        toCompare = noOfCoins[amount - denom] + 1;
                    }
                    noOfCoins[amount] = Math.min(noOfCoins[amount], toCompare);
                }
            }
        }
        return noOfCoins[n] != Integer.MAX_VALUE ? noOfCoins[n] : -1;
    }

    public static void main(String[] args) {
        int[] denoms = {1, 2, 5};
        int sum = 7;
        System.out.println(minNumberOfCoinsForChange(sum, denoms));
    }
}
