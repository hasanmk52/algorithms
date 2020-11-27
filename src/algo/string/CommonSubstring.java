package algo.string;

import java.util.*;

/**
 * @author hasankagalwala on 6/3/20
 * @project algorithms
 *
 * Given two strings, determine if they share a common substring. A substring may be as small as one character.
 *
 * For example, the words "a", "and", "art" share the common substring a. The words "be" and "cat" do not share a substring
 */
public class CommonSubstring {

    public static void main(String[] args) {
        System.out.println(twoStrings("hello","world"));
    }

    // Complete the twoStrings function below.
    static String twoStrings(String s1, String s2) {
        boolean s = false;
        String w = "";

        Map<Character,Integer > Ma = new HashMap<>();
        Map<Character,Integer> Ma1 = new HashMap<>();

        for (int i = 0 ; i < s1.length(); i++){
            Ma.put(s1.charAt(i) , 1);
        }
        for (int j = 0 ; j < s2.length(); j++){
            Ma1.put(s2.charAt(j) , 1);
        }

        for (Map.Entry<Character , Integer > entry : Ma.entrySet()) {
            if (Ma1.get(entry.getKey()) != null ) {
                s = true;
                break;
            }
        }
        if (s){
            w = "YES";
        }
        else {
            w = "NO";
        }
        return w;

    }

}
