package main.java.algorithm;

/**
 * 5. Longest Palindromic Substring
 * Given a string s, return the longest palindromic substring in s.
 * <p>
 * Example 1:
 * Input: s = "babad"
 * Output: "bab"
 * Explanation: "aba" is also a valid answer.
 * <p>
 * Example 2:
 * Input: s = "cbbd"
 * Output: "bb"
 * <p>
 * Constraints:
 * 1 <= s.length <= 1000
 * s consist of only digits and English letters.
 */
public class LongestPalindrome
{
    public static String longestPalSubstringAroundCenter(String s)
    {
        if (s == null || s.length() < 1) {
            return "";
        }
        int start = 0;
        int end = 0;
        for (int idx = 0; idx < s.length(); idx++) {
            int len1 = expandAroundCenter(s, idx, idx);
            int len2 = expandAroundCenter(s, idx, idx + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = idx - (len - 1) / 2;
                end = idx + len / 2;
            }
        }
        System.out.print("The Longest Palindromic Substring is: ");
        return s.substring(start, end + 1);

    }

    private static int expandAroundCenter(String s, int left, int right)
    {
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    // Implementation of Manacher's Algorithm
    public static String manacherAlgorithm(String s) {
        /*
         If length of given string is n then its length after
         inserting n+1 "#", one "@", and one "$" will be
         (n) + (n+1) + (1) + (1) = 2n+3
        */
        int strLen = 2 * s.length() + 3;
        char[] sChars = new char[strLen];

        /*
         Inserting special characters to ignore special cases
         at the beginning and end of the array
         "abc" -> @ # a # b # c # $
         "" -> @#$
         "a" -> @ # a # $
        */
        sChars[0] = '@';
        sChars[strLen - 1] = '$';
        int t = 1;
        for (char c : s.toCharArray()) {
            sChars[t++] = '#';
            sChars[t++] = c;
        }
        sChars[t] = '#';

        int maxLen = 0;
        int start = 0;
        int maxRight = 0;
        int center = 0;
        int[] p = new int[strLen]; // i's radius, which doesn't include i
        for (int i = 1; i < strLen - 1; i++) {
            if (i < maxRight) {
                p[i] = Math.min(maxRight - i, p[2 * center - i]);
            }

            // Expanding along the center
            while (sChars[i + p[i] + 1] == sChars[i - p[i] - 1]) {
                p[i]++;
            }

            // Updating center and its bound
            if (i + p[i] > maxRight) {
                center = i;
                maxRight = i + p[i];
            }

            // Updating ans
            if (p[i] > maxLen) {
                start = (i - p[i] - 1) / 2;
                maxLen = p[i];
            }
        }

        // Printing the longest Palindromic substring
        System.out.print("The Longest Palindromic Substring is: ");
        return s.substring(start, start + maxLen );
    }

    // Driver Code
    public static void main(String[] args){
        String str = "daabddfddbegtd";
        System.out.println(longestPalSubstringAroundCenter(str));
        System.out.println(manacherAlgorithm(str));
    }
}
