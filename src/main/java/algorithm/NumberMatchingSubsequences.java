package main.java.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * 792. Number of Matching Subsequences
 *
 * Given a string s and an array of strings words, return the number of words[i] that is a subsequence of s.
 * A subsequence of a string is a new string generated from the original string with some characters (can be none)
 * deleted without changing the relative order of the remaining characters.
 *
 * For example, "ace" is a subsequence of "abcde".
 *
 * Example 1:
 * Input: s = "abcde", words = ["a","bb","acd","ace"]
 * Output: 3
 * Explanation: There are three strings in words that are a subsequence of s: "a", "acd", "ace".
 *
 * Example 2:
 * Input: s = "dsahjpjauf", words = ["ahjpjau","ja","ahbwzgqnuk","tnmlanowax"]
 * Output: 2
 *
 *  Constraints:
 *
 * 1 <= s.length <= 5 * 104
 * 1 <= words.length <= 5000
 * 1 <= words[i].length <= 50
 * s and words[i] consist of only lowercase English letters.
 *
 */
public class NumberMatchingSubsequences
{

    public static void main(String[] args)
    {
        String s = "abcde";
        String[] words = {"a", "bb", "acd", "ace"};
        System.out.println(numMatchingSubseq(s, words));
    }

    public static int numMatchingSubseq(String s, String[] words) {
        Map<String,Integer> map = new HashMap<>();
        for(String str:words){
            map.put(str,map.getOrDefault(str,0)+1);
        }

        int max = 0;
        char[] stringMain = s.toCharArray();
        int match;
        int idx;

        for(String str:map.keySet()) {
            char[] it = str.toCharArray();
            match = 0;
            idx = 0;
            while( idx < stringMain.length && match < it.length){
                if(stringMain[idx] == it[match]){
                    idx++;
                    match++;
                } else {
                    idx++;
                }
            }
            if(match == str.length()) {
                max+=map.get(str);
            }
        }
        return max;
    }

}
