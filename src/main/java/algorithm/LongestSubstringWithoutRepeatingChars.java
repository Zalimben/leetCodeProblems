package main.java.algorithm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given a string s, find the length of the longest substring without repeating characters.
 *
 * Example 1:
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 *
 * Example 2:
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 *
 * Example 3:
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 * Example 4:
 * Input: s = "au"
 * Output: 2
 * Explanation: The answer is "au", with the length of 2.
 *
 * Example 5:
 * Input: s = "dvdf"
 * Output: 3
 * Explanation: The answer is "vdf", with the length of 3.
 *
 * Constraints:
 * 0 <= s.length <= 5 * 104
 * s consists of English letters, digits, symbols and spaces.
 */
public class LongestSubstringWithoutRepeatingChars
{
    public static void main(String[] args)
    {
        List<String> testStrings = new ArrayList<>();
        testStrings.add("abcabcbb");
        testStrings.add("bbbbb");
        testStrings.add("pwwkew");
        testStrings.add("au");
        testStrings.add("dvdf");
        System.out.println("longestSubstring");
        testStrings.forEach( s -> System.out.println(longestSubstring(s)));
        System.out.println("lengthOfLongestSubstring");
        testStrings.forEach( s -> System.out.println(lengthOfLongestSubstring(s)));
    }

    public static int longestSubstring(String s)
    {
        int max = 0;
        if(s.length() == 0) {
            return max;
        }
        String result = "";
        result += s.charAt(0);
        max = result.length();
        for(int idx = 1; idx < s.length(); idx++) {
            CharSequence value = s.subSequence(idx, idx + 1);
            if(result.contains(value)) {
                max = Math.max(max, result.length());
                String sub = result.substring(0, result.indexOf((String)value) + 1 );
                result = result.replace(sub, "");
            }
            result += value;
        }
        return Math.max(max, result.length());
    }

    public static int lengthOfLongestSubstring(String s) {
        Set<Character> uniqueSet = new HashSet<>();
        int duplicate = 0;
        int init = 0;
        int max = 0;

        char[] chars = s.toCharArray();
        while(init < chars.length)
        {
            if(!uniqueSet.contains(chars[init])) {
                uniqueSet.add(chars[init]);
                init++;
            } else {
                max = Math.max(max,uniqueSet.size());
                uniqueSet.remove(chars[duplicate]);
                duplicate++;
            }
        }
        return Math.max(max,uniqueSet.size());
    }

}
