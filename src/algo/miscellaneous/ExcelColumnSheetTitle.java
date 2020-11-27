package algo.miscellaneous;

/**
 * @author hasankagalwala on 10/14/20
 * @project algorithms
 */
public class ExcelColumnSheetTitle {
    public static String convertToTitle(int n) {
        StringBuilder builder = new StringBuilder();
        while(n > 0) {
            n--;
            builder.append((char) ('A' + n % 26));
            n /= 26 ;
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(convertToTitle(1));
        System.out.println(convertToTitle(26));
        System.out.println(convertToTitle(27));
        System.out.println(convertToTitle(701));
        System.out.println(convertToTitle(702));
        System.out.println(convertToTitle(703));
    }
}
