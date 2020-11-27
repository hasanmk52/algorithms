package algo.string;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hasankagalwala on 5/15/20
 * @project algorithms
 *
 * //Find the Longest Substring without Repeating Characters
 *
 * For example, the longest substring of unique letters in “CODINGISAWESOME” is “NGISAWE”.
 *
 * Algorithm:
 * We start traversing the string from left to right and maintain track of:
 * 1.) the current substring with non-repeating characters with the help of a start and end index
 * 2.) the longest non-repeating substring output
 *
 * For every new character, we look for it in the already visited characters.
 * If the character has already been visited and is part of the current substring with non-repeating characters,
 * we update the start index.
 * Otherwise, we'll continue traversing the string.
 */
public class LongestDistinctSubstring {

    public static void main(String[] args) {
        String input = "CODINGISAWESOME";
        Map<Character, Integer> visited = new HashMap<>();
        String output = "";
        int start = 0;
        int end = 0;
        while(end < input.length()) {
            char currChar = input.charAt(end);
            if (visited.containsKey(currChar)) {
                start = Math.max(visited.get(currChar)+1, start);
            }
            if (output.length() < (end - start + 1)) {
                output = input.substring(start, end + 1);
            }
            visited.put(currChar, end);
            end++;
        }
        System.out.println(output);
    }
}
