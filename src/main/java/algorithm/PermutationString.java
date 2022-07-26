package main.java.algorithm;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 567. Permutation in String
 * <p>
 * Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.
 * In other words, return true if one of s1's permutations is the substring of s2.
 * <p>
 * Example 1:
 * Input: s1 = "ab", s2 = "eidbaooo"
 * Output: true
 * Explanation: s2 contains one permutation of s1 ("ba").
 * <p>
 * Example 2:
 * Input: s1 = "ab", s2 = "eidboaoo"
 * Output: false
 * <p>
 * Constraints:
 * 1 <= s1.length, s2.length <= 104
 * s1 and s2 consist of lowercase English letters.
 */
public class PermutationString
{
    public static void main(String[] args)
    {
        String permutation = "fd";
        String source = "dvdf";
        boolean isPermutation = isPermutation(permutation, source);
        System.out.println(isPermutation);
    }

    public static boolean isPermutation(String s1, String s2)
    {
        // s1 is longer than s2, it cannot be a substring
        int permLength = s1.length();
        int sourceLength = s2.length();
        if(permLength > sourceLength) {
            return false;
        }

        // Extract char groups
        Set<String> charMap = new HashSet<>();
        int idx = 0;
        while( idx + permLength <= sourceLength) {
            charMap.add(s2.substring(idx, idx + permLength));
            idx++;
        }

        s1 = sort(s1);
        for( String words : charMap ) {
            words = sort(words);
            if( words.equals(s1) ) {
                return true;
            }
        }
        return false;
    }

    public static String sort(String s) {
        char[] t = s.toCharArray();
        Arrays.sort(t);
        return new String(t);
    }

}
