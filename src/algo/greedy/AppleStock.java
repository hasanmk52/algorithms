package algo.greedy;

/**
 * @author hasankagalwala on 4/29/20
 * @project algorithms
 *
 * A greedy algorithm builds up a solution by choosing the option that looks the best at every step.
 *
 * Determine how much money I could have made yesterday if I'd been trading Apple stocks all day.
 *
 * So I grabbed Apple's stock prices from yesterday and put them in an array called stockPrices, where:
 *
 * The indices are the time (in minutes) past trade opening time, which was 9:30am local time.
 * The values are the price (in US dollars) of one share of Apple stock at that time.
 * So if the stock cost $500 at 10:30am, that means stockPrices[60] = 500.
 * Note: You need to buy before you can sell. Also, you can't buy and sell in the same time step—at least 1 minute has to pass.
 *
 * Write an efficient method that takes stockPrices and returns the best profit I could have made from one purchase and one sale of one share of Apple stock yesterday.
 * For example:
 *
 * int[] stockPrices = new int[] {10, 7, 5, 8, 11, 9};
 *
 * getMaxProfit(stockPrices); // returns 6 (buying for $5 and selling for $11)
 *
 */
public class AppleStock {

    public static void main(String[] args) {
        int[] stockPrices = new int[] {10, 7, 5, 8, 11, 9};
        System.out.println(getMaxProfit(stockPrices));
    }

    public static int getMaxProfit(int[] stockPrices) {

        /*
         * We'll start our maxProfit at $0 and maxProfit at the first profit we could get—if we buy at the first time and sell at the second time..
         * As we're iterating, how do we know if we've found a new maxProfit?
         *  At each iteration, our maxProfit is either:
         * 1.) the same as the maxProfit at the last time step, or
         * 2.) the max profit we can get by selling at the currentPrice
         * How do we know when we have case (2)?
         * The max profit we can get by selling at the currentPrice is simply the difference between the currentPrice and the minPrice from earlier in the day.
         * If this difference is greater than the current maxProfit, we have a new maxProfit.
         * */

        if (stockPrices.length < 2) {
            throw new IllegalArgumentException("Getting a profit requires at least 2 prices");
        }

        // we'll greedily update minPrice and maxProfit, so we initialize them to the first price and the first possible profit
        int minPrice = stockPrices[0];
        int maxProfit = stockPrices[1] - stockPrices[0];

        // Start at the second (index 1) time
        // we can't sell at the first time, since we must buy first, and we can't buy and sell at the same time!
        // If we started at index 0, we'd try to buy *and* sell at time 0.
        // this would give a profit of 0, which is a problem if our maxProfit is supposed to be *negative*--we'd return 0.

        for (int i = 1; i < stockPrices.length; i++) {
            int currentPrice = stockPrices[i];

            // see what our profit would be if we bought at the min price and sold at the current price
            int potentialProfit = currentPrice - minPrice;

            // update maxProfit if we can do better
            maxProfit = Math.max(maxProfit, potentialProfit);

            // update minPrice so it's always the lowest price we've seen so far
            minPrice = Math.min(minPrice, currentPrice);
        }

        return maxProfit;
    }

}
