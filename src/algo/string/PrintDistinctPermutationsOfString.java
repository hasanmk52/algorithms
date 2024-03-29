package algo.string;

/**
 * @author hasankagalwala on 6/3/20
 * @project algorithms
 *
 * Print all permutations of a given string. For example, xy would be xy and yx.
 *
 */
public class PrintDistinctPermutationsOfString {

    public static void main(String a[]) {

        String str = "ABCD";
        int n = str.length();
        permute(str, 0, n-1);
    }

    private static void permute(String str, int l, int r) {
        if (l == r)
            System.out.println(str);
        else {
            for (int i = l; i <= r; i++) {
                str = swap(str,l,i);
                permute(str, l+1, r);
                str = swap(str,l,i);
            }
        }
    }

    //Swap Characters at position
    private static String swap(String a, int i, int j) {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i] ;
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }
}
