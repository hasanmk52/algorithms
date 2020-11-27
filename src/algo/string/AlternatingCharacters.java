package algo.string;

/**
 * @author hasankagalwala on 6/3/20
 * @project algorithms
 *
 * You are given a string containing characters A and B only. Your task is to change it into a string such that
 * there are no matching adjacent characters. To do this, you are allowed to delete zero or more characters in the string.
 *
 * Your task is to find the minimum number of required deletions.
 *
 * For example, given the string s="AABAAB, remove an A at positions 0 and 3 to make s="ABAB" in 2 deletions.
 */
public class AlternatingCharacters {

    public static void main(String[] args) {
        System.out.println(alternatingCharacters("AABAAB"));
    }

    private static int alternatingCharacters(String s) {
        int count=0;
        for (int i = 0; i < s.length()-1; i++) {
            if(s.charAt(i) == s.charAt(i+1))
                count++;
        }
        return count;
    }
}
