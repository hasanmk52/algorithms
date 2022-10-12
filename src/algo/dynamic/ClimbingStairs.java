package algo.dynamic;

/**
 * You are climbing a staircase. It takes n steps to reach the top.
 * Each time you can either climb 1 or 2 steps.
 * Input: n = 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 **/
public class ClimbingStairs {

    public static void main(String[] args) {
        System.out.println(climbStairs(5));
    }

    private static int climbStairs(int n) {
        int one = 1, two = 1, temp;
        for(int i = 0; i < n - 1; i++) {
            temp = one;
            one = one + two;
            two = temp;
        }
        return one;
    }
}
