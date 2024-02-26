package main.java.algorithm;

/**
 * 9. Palindrome Number
 * Given an integer x, return true if x is a palindrome , and false otherwise.
 * <p>
 * Example 1:
 * <p>
 * Input: x = 121
 * Output: true
 * Explanation: 121 reads as 121 from left to right and from right to left.
 * Example 2:
 * <p>
 * Input: x = -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 * Example 3:
 * <p>
 * Input: x = 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * -2<sup>31</sup> <= x <= 2<sup>31</sup> - 1
 */
public class PalindromeNumber {

    public static void main(String[] args) {
        int x = 123321;
        if (isNumberPalindrome(x)) {
            System.out.println("The number is palindrome");
        } else {
            System.out.println("The number is not palindrome");
        }
    }

    public static boolean isNumberPalindrome(int number) {
        if (number < 0) {
            return false;
        }

        long reversed = 0;
        long temp = number;
        long digit;
        while (temp != 0) {
            digit = temp % 10;
            reversed = reversed * 10 + digit;
            temp /= 10;
        }
        return reversed == number;
    }

}
