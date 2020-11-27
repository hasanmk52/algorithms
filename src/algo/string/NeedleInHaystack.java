package algo.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hasankagalwala on 5/13/20
 * @project algorithms
 *
 * The Problem is simple Find Needle in Haystack and return the array of indexes.
 * Eg: Input: haystack = "ABCDSGDABCSAGAABCCDSAAABAABC"
 *            needle = "CDS"
 *     Output: [2, 17]
 *
 */
public class NeedleInHaystack {

    public static void main(String[] args) {

        String haystack = "ABCDSGDABCSAGAABCCDSAAABAABC";
        String needle = "CDS";
        List<Integer> result = needleHaystack(needle,haystack);
        System.out.println(result);
    }

    public static List<Integer> needleHaystack(String needle, String haystack) {

        List<Integer> result = new ArrayList<>();
        int p = 0;
        if(needle.length() == 0 || needle.length() > haystack.length()) {
            return result;
        }

        while(p < (haystack.length() - needle.length())) {
            if(haystack.charAt(p) == needle.charAt(0)) {
                if(compareStrings(needle,haystack,p)) {
                    result.add(p);
                }
            }
            p++;
        }
        return result;
    }

    private static boolean compareStrings(String needle, String haystack, int p) {

        int p2 = 0;
        while(p2 < needle.length()) {
            if(needle.charAt(p2) != haystack.charAt(p)) {
                return false;
            }
            p2++;
            p++;
        }
        return true;
    }
}
