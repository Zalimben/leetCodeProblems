package main.java.leetCodeProblems.algorithm;

/**
 * Given a string s, reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
 * <p>
 * Example 1:
 * Input: s = "Let's take LeetCode contest"
 * Output: "s'teL ekat edoCteeL tsetnoc"
 * <p>
 * Example 2:
 * Input: s = "God Ding"
 * Output: "doG gniD"
 * <p>
 * Constraints:
 * 1 <= s.length <= 5 * 104
 * s contains printable ASCII characters.
 * s does not contain any leading or trailing spaces.
 * There is at least one word in s.
 * All the words in s are separated by a single space.
 */
public class ReverseWordsInString
{
    public static void main(String[] args)
    {
        String s = "God Ding";
        String r = reverseWord(s);
        System.out.println(s);
        System.out.println(r);
    }

    private static String reverseWord(String s)
    {
        String[] splits = s.split(" ");
        int start;
        int end;
        char aux;
        char[] string;
        for(int idx = 0; idx < splits.length; idx++) {
            String word = splits[idx];
            string = word.toCharArray();
            start = 0;
            end = string.length - 1;
            while(start < end) {
                aux = string[start];
                string[start] = string[end];
                string[end] = aux;
                start++;
                end--;
            }
            splits[idx] = String.copyValueOf(string);
        }
        return String.join(" ", splits);
    }
}
