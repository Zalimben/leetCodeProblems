package main.java.algorithm;

import java.util.HashSet;
import java.util.Set;

/**
 * 804. Unique Morse Code Words
 * <p>
 * International Morse Code defines a standard encoding where each letter is mapped to a series of dots and dashes, as follows:
 * <p>
 * 'a' maps to ".-",
 * 'b' maps to "-...",
 * 'c' maps to "-.-.", and so on.
 * For convenience, the full table for the 26 letters of the English alphabet is given below:
 * <p>
 * [".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]
 * Given an array of strings words where each word can be written as a concatenation of the Morse code of each letter.
 * <p>
 * For example, "cab" can be written as "-.-..--...", which is the concatenation of "-.-.", ".-", and "-...".
 * We will call such a concatenation the transformation of a word.
 * Return the number of different transformations among all words we have.
 * <p>
 * Example 1:
 * Input: words = ["gin","zen","gig","msg"]
 * Output: 2
 * Explanation: The transformation of each word is:
 * "gin" -> "--...-."
 * "zen" -> "--...-."
 * "gig" -> "--...--."
 * "msg" -> "--...--."
 * There are 2 different transformations: "--...-." and "--...--.".
 * <p>
 * Example 2:
 * Input: words = ["a"]
 * Output: 1
 * <p>
 * Constraints:
 * 1 <= words.length <= 100
 * 1 <= words[i].length <= 12
 * words[i] consists of lowercase English letters.
 *
 */
public class UniqueMorseCodeWords
{


    public static void main(String[] args)
    {
        String[] words = {"gin","zen","gig","msg"};
        System.out.println(uniqueMorseRepresentations(words)); ;
    }

    public static int uniqueMorseRepresentations(String[] words) {
        String[] MORSE = {
            ".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.",
            "...","-","..-","...-",".--","-..-","-.--","--.."
        };
        Set<String> codeWords = new HashSet<>();

        for(String word : words) {
            StringBuilder sb = new StringBuilder();
            char[] letters = word.toCharArray();
            for(char letter : letters) {
                sb.append(MORSE[letter - 'a'] );
            }
            codeWords.add(sb.toString());
        }

        return codeWords.size();
    }

}
