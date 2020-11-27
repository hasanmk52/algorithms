package algo.inplace;

import java.util.Arrays;

/**
 * @author hasankagalwala on 5/4/20
 * @project algorithms
 *
 * An in-place method modifies data structures or objects outside of its own stack frame (i.e.: stored on the process heap or in the stack frame of a calling function).
 * Because of this, the changes made by the method remain after the call completes.
 *
 * Write a method reverseWords() that takes a message as an array of characters and reverses the order of the words in place.
 *
 *  For this we'll write a helper method reverseCharacters() that reverses all the characters between a leftIndex and rightIndex. We use it to:
 *
 *  1.) Reverse all the characters in the entire message, giving us the correct word order but with each word backward.
 *  2.) Reverse the characters in each individual word.
 *
 *  Solution:
 *  Let's do a character-level reversal:
 *
 *  // input: the eagle has landed
 *  { 't', 'h', 'e', ' ', 'e', 'a', 'g', 'l', 'e', ' ',
 *    'h', 'a', 's', ' ', 'l', 'a', 'n', 'd', 'e', 'd' };
 *
 *  // character-reversed: dednal sah elgae eht
 *  { 'd', 'e', 'd', 'n', 'a', 'l', ' ', 's', 'a', 'h', ' ',
 *    'e', 'l', 'g', 'a', 'e', ' ', 'e', 'h', 't' };
 *
 *  // word-reversed (desired output): landed has eagle the
 *  { 'l', 'a', 'n', 'd', 'e', 'd', ' ', 'h', 'a', 's', ' ',
 *    'e', 'a', 'g', 'l', 'e', ' ', 't', 'h', 'e' };
 *
 *  The character reversal reverses the words! It's a great first step. From there, we just have to "unscramble" each word.
 *
 *  More precisely, we just have to re-reverse each word!
 *
 * */
public class ReverseWords {

    public static void main(String[] args) {
        String s = "the eagle has landed";
        System.out.println(Arrays.toString(reverseWords(s.toCharArray())));
    }

    public static char[] reverseWords(char[] message) {

        // first we reverse all the characters in the entire message array
        // this gives us the right word order
        // but with each word backward
        reverseCharacters(message, 0, message.length - 1);

        // now we'll make the words forward again by reversing each word's characters
        // we hold the index of the *start* of the current word as we look for the *end* of the current word
        int currentWordStartIndex = 0;
        for (int i = 0; i <= message.length; i++) {

            // found the end of the current word!
            if (i == message.length || message[i] == ' ') {

                // if we haven't exhausted the array, our
                // next word's start is one character ahead
                reverseCharacters(message, currentWordStartIndex, i - 1);
                currentWordStartIndex = i + 1;
            }
        }
        return message;
    }

    private static void reverseCharacters(char[] message, int leftIndex, int rightIndex) {

        // walk towards the middle, from both sides
        while (leftIndex < rightIndex) {

            // swap the left char and right char
            char temp = message[leftIndex];
            message[leftIndex] = message[rightIndex];
            message[rightIndex] = temp;
            leftIndex++;
            rightIndex--;
        }
    }
}
