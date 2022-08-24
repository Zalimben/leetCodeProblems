package main.java.algorithm;

/**
 * 326. Power of Three
 * <p>
 * Given an integer n, return true if it is a power of three. Otherwise, return false.
 * <p>
 * An integer n is a power of three, if there exists an integer x such that n == 3x.
 * <p>
 * Example 1:
 * Input: n = 27
 * Output: true
 * <p>
 * Example 2:
 * Input: n = 0
 * Output: false
 * <p>
 * Example 3:
 * Input: n = 9
 * Output: true
 * <p>
 * Constraints:
 * -231 <= n <= 231 - 1
 */
public class PowerOfThree
{
    public static void main(String[] args)
    {
        int num = 9;
        System.out.println(isPowerOfThree(num));
    }

    /**
     * Solution based on Logarithm's Theory.
     * @see PowerOfFour#isPowerOfFour(int)
     */
    public static boolean isPowerOfThree(int n) {
        if (n == 1) {
            return true;
        }
        if (n<1) {
            return false;
        }
        return ((Math.log10(n)/Math.log10(3)) % 1 == 0);
    }
}
