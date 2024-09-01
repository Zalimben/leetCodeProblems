package main.java.algorithm;

import java.util.logging.Logger;

/**
 * 1768. Merge Strings Alternately
 * <p>
 * You are given two strings word1 and word2. Merge the strings by adding letters in alternating order, starting with word1.
 * If a string is longer than the other, append the additional letters onto the end of the merged string.
 * <p>
 * Return the merged string.
 * <p>
 * Example 1:
 * <p>
 * Input: word1 = "abc", word2 = "pqr"
 * Output: "apbqcr"
 * Explanation: The merged string will be merged as so:
 * word1:  a   b   c
 * word2:    p   q   r
 * merged: a p b q c r
 * Example 2:
 * <p>
 * Input: word1 = "ab", word2 = "pqrs"
 * Output: "apbqrs"
 * Explanation: Notice that as word2 is longer, "rs" is appended to the end.
 * word1:  a   b
 * word2:    p   q   r   s
 * merged: a p b q   r   s
 * Example 3:
 * <p>
 * Input: word1 = "abcd", word2 = "pq"
 * Output: "apbqcd"
 * Explanation: Notice that as word1 is longer, "cd" is appended to the end.
 * word1:  a   b   c   d
 * word2:    p   q
 * merged: a p b q c   d
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= word1.length, word2.length <= 100
 * word1 and word2 consist of lowercase English letters.
 */
public class MergeStringsAlternately {
    private static final Logger log = Logger.getLogger(MergeStringsAlternately.class.getName());

    public static void main(String[] args) {
        String word1 = "ab";
        String word2 = "pqrs";
        String result = mergeAlternately(word1, word2);
        log.info(() -> String.format("Merge Strings Alternately: word1: %s, word2: %s, result: %s",
                word1, word2, result));
    }

    public static String mergeAlternately(String word1, String word2) {
        // 1 <= word1.length, word2.length <= 100
        if(word1 == null || word2 == null || word1.isEmpty() || word2.isEmpty()) {
            return "";
        }
        if(word1.length() > 100 || word2.length() > 100  ) {
            return "";
        }
        int idxWord = 0;
        StringBuilder result = new StringBuilder();
        while (idxWord < word1.length() || idxWord < word2.length()) {
            if(idxWord < word1.length()) {
                result.append(word1.charAt(idxWord));
            }
            if(idxWord < word2.length()) {
                result.append(word2.charAt(idxWord));
            }
            idxWord++;
        }
        return result.toString();
    }

}
