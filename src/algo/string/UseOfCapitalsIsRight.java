package algo.string;

import java.util.function.Predicate;

/**
 * @author hasankagalwala on 9/5/20
 * @project algorithms
 *
 * Given a word, you need to judge whether the usage of capitals in it is right or not.
 * We define the usage of capitals in a word to be right when one of the following cases holds:
 *
 * All letters in this word are capitals, like "USA".
 * All letters in this word are not capitals, like "leetcode".
 * Only the first letter in this word is capital, like "Google".
 */
public class UseOfCapitalsIsRight {
    public static void main(String[] args) {
        System.out.println(detectCapitalsUsage("leetcode"));
    }

    private static boolean detectCapitalsUsage(String word) {
        if (word.length() <= 1) return true;
        Predicate<Character> correctCase = Character::isLowerCase;
        if(Character.isUpperCase(word.charAt(0)) && Character.isUpperCase(word.charAt(1))) {
            correctCase = Character::isUpperCase;
        }
        for(int i=1; i < word.length(); i++) {
            if(!correctCase.test(word.charAt(i))) return false;
        }
        return true;
    }

}
