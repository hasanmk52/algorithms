package algo.string;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author hasankagalwala on 5/15/20
 * @project algorithms
 *
 * //Find number of Distinct Permutations of a String
 *
 * Approach:
 * Number of ways to arrange n distinct items are = n!.
 * If we have duplicate items, say one item repeated m1 times, then we need to divide n! by m1!.
 * Since these items can be arranged in m1! ways but that will not produce any different results.
 * For example let’s say we have 6 items {a, b, a, c, d, c}, we have ‘a’ which is occurring twice.
 * So in one of the permutation – ‘aabccd’ . if we replace ‘a’ at 0th index and ‘a’ at 1st index, it will not produce any different result.
 * ‘aa’ can be arranged in !2 ways. Same with ‘c’ So our final result will be 6!/(2!*2!).
 *
 * String x = "abc"
 * Output: 6 (abc, acb, bac, bca, cab, cba)
 *
 * String x = "aab"
 * Output: 3 (aab, aba, baa)
 *
 * Time complexity: O(n)
 *
 */
public class NoOfDistinctPermutations {

    public static void main(String[] args) {
        String input = "abc";
        permutations(input);
        input = "aabc";
        permutations(input);
        input = "aabccd";
        permutations(input);
    }

    public static void permutations(String input){
        //covert string to char array
        char[] chars = input.toCharArray();

        //create a HashMap
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i <chars.length ; i++) {
            char x = chars[i];
            if(map.containsKey(x)) {
                int count = map.get(x);
                count++;
                map.put(x, count);
            } else
                map.put(x, 1);
        }

        int result = factorial(chars.length);

        //handle duplicates, divide the result by all the counts factorial in the hash map

        Set set = map.keySet();
        Iterator<Character> iterator = set.iterator();
        while (iterator.hasNext()){
            char key = iterator.next();
            int count = map.get(key);
            //divide the result by count
            int factorialCount = factorial(count);
            result = result/factorialCount;
        }

        System.out.println("Number of distinct permutations of String: '" + input + "' are: " + result);
    }

    public static int factorial(int num){
        if(num==0)
            return 1;
        int result = 1;
        for (int i = 2; i <=num ; i++) {
            result *= i;
        }
        return result;
    }

}
