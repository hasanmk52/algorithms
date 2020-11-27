package algo.string;

/**
 * @author hasankagalwala on 6/3/20
 * @project algorithms
 *
 * Given a string of lowercase letters in the range ascii[a-z], determine a character that can be removed to make the
 * string a palindrome. There may be more than one solution, but any will do. For example, if your string is "bcbc",
 * you can either remove 'b' at index 0 or 'c' at index 3. If the word is already a palindrome or there is no solution,
 * return -1. Otherwise, return the index of a character to remove.
 *
 */
public class RemoveCharacterToMakeStringPalindrome {

    public static void main(String[] args) {
        System.out.println(palindromeIndex("bcbc"));
        System.out.println(palindromeIndex("aaab"));
        System.out.println(palindromeIndex("abca"));
        System.out.println(palindromeIndex("abba"));
    }

    private static int palindromeIndex(String s) {
        int len = s.length();
        int start = 0, end = len-1;
        while(start < end) {
            if(s.charAt(start) != s.charAt(end)) {
                if((s.charAt(start+1) == s.charAt(end)) && (s.charAt(start+2) == s.charAt(end-1)))
                    return start;
                else
                    return end;
            }
            start++;
            end--;
        }
        return -1;
    }
}
