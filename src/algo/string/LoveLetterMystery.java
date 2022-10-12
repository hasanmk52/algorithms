package algo.string;

/**
 * @author hasankagalwala on 6/3/20
 * @project algorithms
 *
 * James found a love letter that his friend Harry has written to his girlfriend. James is a prankster, so he decides to
 * meddle with the letter. He changes all the words in the letter into palindromes.
 *
 * To do this, he follows two rules:
 *
 * He can only reduce the value of a letter by 1, i.e. he can change d to c, but he cannot change c to d or d to b.
 * The letter a may not be reduced any further.
 *
 * Each reduction in the value of any letter is counted as a single operation.
 * Find the minimum number of operations required to convert a given string into a palindrome.
 *
 * For example, given the string s="cde", the following two operations are performed: cde → cdd → cdc.
 *
 * Complete the theLoveLetterMystery function in the editor below.
 * It should return the integer representing the minimum number of operations needed to make the string a palindrome.
 */
public class LoveLetterMystery {

    public static void main(String[] args) {
        System.out.println(theLoveLetterMystery("abcd"));
    }

    private static int theLoveLetterMystery(String s) {

        int count = 0;
        int i = 0;
        int j = s.length() -1;
        while(i < j){
            int start = s.charAt(i);
            int end = s.charAt(j);
            int diff = Math.abs(start - end);
            count = count + diff;
            i++;
            j--;
        }
        return count;
    }
}
