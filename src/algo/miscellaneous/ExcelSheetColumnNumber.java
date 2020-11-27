package algo.miscellaneous;

/**
 * @author hasankagalwala on 10/15/20
 * @project algorithms
 */
public class ExcelSheetColumnNumber {

    public static int titleToNumber(String s) {
        int result = 0;
        for(char c : s.toCharArray()) {
            int d = c - 'A' + 1;
            result = result * 26 + d;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(titleToNumber("A"));
        System.out.println(titleToNumber("BCD"));
        System.out.println(titleToNumber("Z"));
        System.out.println(titleToNumber("AA"));
        System.out.println(titleToNumber("AB"));
    }
}
