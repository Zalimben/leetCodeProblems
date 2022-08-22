package main.java.algorithm;

/**
 * 342. Power of Four
 * <p>
 * Given an integer n, return true if it is a power of four. Otherwise, return false.
 * An integer n is a power of four, if there exists an integer x such that n == 4^x.
 * <p>
 * Example 1:
 * Input: n = 16
 * Output: true
 * <p>
 * Example 2:
 * Input: n = 5
 * Output: false
 * <p>
 * Example 3:
 * Input: n = 1
 * Output: true
 * <p>
 * Constraints:
 * -231 <= n <= 231 - 1
 */
public class PowerOfFour {

    public static void main(String[] args) {
        int n = 16;
        System.out.println(isPowerOfFour(n));
    }

    /**
     * Solution based on Logarithm's Theory.
     * <p>
     *     <ul>
     *         <li>
     *             Rule: Power Rule <br>
     *              log(M^k) = (k) . log(M)<br>
     *          The logarithm of an exponential number is the exponent times the logarithm of the base.
     *          </li>
     *     </ul>
     * If a number (N) is a Power of x, then the logarithm of N in the base of x would be an integer.
     * <pre>
     *      n = 4^x
     *      log (n) = x . log(4)
     *      x = log (n) / log 4
     * </pre>
     *
     * To use Math.log(N) in Java in a base other than 10, the formula is: Math.log(n) / Math.log(x) (Change base formula).
     * Math.log() in Java returns a Double
     * <p>
     * To determine of the result is an integer, determine if the modulo % of the result divided by 1 is 0.
     * If so, then the n is a power of x
     */
    public static boolean isPowerOfFour(int n) {
        if (n == 1) {
            return true;
        }
        if (n<1) {
            return false;
        }

        return ((Math.log(n)/Math.log(4)) % 1 == 0);
    }
}
