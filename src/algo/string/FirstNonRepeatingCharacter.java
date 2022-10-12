package algo.string;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hasankagalwala on 28/08/2021
 * @project algorithms
 *
 * Write a function that takes a string of lower case alphabet letters and returns the index
 * of the string's first non-repeating character.
 * The first non-repeating character is the first character in the string that occurs
 * only once.
 * If the input string doesn't have any, then return -1
 *
 * Sample Input: "abcdcaf"
 * Output: 1 //The first non-repeating character is "b" and is found at index 1
 *
 * O(n) time and O(1) space where n is length of input string. The constant space is
 * because the input string has only lower case alphabets thus our hash table will never
 * have more than 26 character frequencies.
 */
public class FirstNonRepeatingCharacter {

    public static int firstNonRepeatingCharacter(String string) {
        Map<Character, Integer> characterFrequencies = new HashMap<>();

        //store the count of occurrences first for each character
        for(int idx = 0; idx < string.length(); idx++) {
            char character = string.charAt(idx);
            characterFrequencies.put(character, characterFrequencies.getOrDefault(character, 0) + 1);
        }

        //at the first occurence of count 1 return it as it is the one that is first
        //non-repeating
        for(int idx=0; idx < string.length(); idx++) {
            char character = string.charAt(idx);
            if(characterFrequencies.get(character) == 1) {
                return idx;
            }
        }

        return -1;


    }

    public static void main(String[] args) {
        System.out.println(firstNonRepeatingCharacter("abcdcaf"));
    }
}
