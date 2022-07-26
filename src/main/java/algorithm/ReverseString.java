package main.java.algorithm;

/**
 * 344. Reverse String
 *
 * Write a function that reverses a string. The input string is given as an array of characters s.
 * You must do this by modifying the input array in-place with O(1) extra memory.
 * <p>
 * Example 1:
 * Input: s = ["h","e","l","l","o"]
 * Output: ["o","l","l","e","h"]
 * Example 2:
 * <p>
 * Input: s = ["H","a","n","n","a","h"]
 * Output: ["h","a","n","n","a","H"]
 * <p>
 * Constraints:
 * 1 <= s.length <= 105
 * s[i] is a printable ascii character.
 */
public class ReverseString
{
    public static void main(String[] args)
    {
        char[] string = {'a', 'b', 'c', 'd', 'e'};
        reverseString(string);
        for(char num : string) {
            System.out.print(num);
        }
    }

    private static void reverseString(char[] string)
    {
        int start = 0;
        int end = string.length - 1;
        char aux;
        while(start < end) {
            aux = string[start];
            string[start] = string[end];
            string[end] = aux;
            start++;
            end--;
        }
    }
}
