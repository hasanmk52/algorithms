package algo.string;

/**
 * @author hasankagalwala on 5/16/20
 * @project algorithms
 *
 * //Given a string s, find the longest palindromic substring in s.
 * Example:
 *
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 *
 * Input: "cbbd"
 * Output: "bb"
 *
 * Longest Palindromic Substring is a classic dynamic programming problem.
 */
public class LongestPalindromicSubstring {

    //O(n^2) time and O(n) space
    public static String longestPalindromicSubstring(String str) {
        int[] currentLongest = {0, 1};
        for(int i=1; i < str.length(); i++) {
            int[] odd = getLongestPalindromeFrom(str, i - 1, i + 1);
            int[] even = getLongestPalindromeFrom(str, i - 1, i);
            int[] longest = odd[1] - odd[0] > even[1] - even[0] ? odd : even;
            currentLongest =
                    currentLongest[1] - currentLongest[0] > longest[1] - longest[0]
                            ? currentLongest
                            : longest;
        }
        return str.substring(currentLongest[0], currentLongest[1]);
    }

    private static int[] getLongestPalindromeFrom(String str, int leftIdx, int rightIdx) {
        while(leftIdx >=0 && rightIdx < str.length()) {
            if(str.charAt(leftIdx) != str.charAt(rightIdx)) {
                break;
            } else {
                leftIdx--;
                rightIdx++;
            }
        }
        return new int[] {leftIdx + 1, rightIdx};
    }

    public static void main(String[] args) {
        String input = "bababbdbababad";
        System.out.println(longestPalindromicSubstring(input));
    }
}
