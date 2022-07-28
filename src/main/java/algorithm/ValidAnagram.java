package main.java.algorithm;

import java.util.Arrays;

import main.java.algorithm.utils.StringUtils;

/**
 * 242. Valid Anagram
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
 * typically using all the original letters exactly once.
 * <p>
 * Example 1:
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 * <p>
 * Example 2:
 * Input: s = "rat", t = "car"
 * Output: false
 * <p>
 * Constraints:
 * 1 <= s.length, t.length <= 5 * 104
 * s and t consist of lowercase English letters.
 * Follow up: What if the inputs contain Unicode characters? How would you adapt your solution to such a case?
 */
public class ValidAnagram
{
    public static void main(String[] args)
    {
        String s = "anagram";
        String t = "nagaram";
        boolean isAnagram = isAnagram(s,t);
    }

    public static boolean isAnagram(String s, String t) {

        if(s.length() != t.length()) {
            return false;
        }
        String isAna = StringUtils.sort(s);
        String source = StringUtils.sort(t);

        return source.contains(isAna);
    }
}
