package main.java.algorithm;

import java.util.Arrays;
import java.util.logging.Logger;

/**
 * 2239. Find Closest Number to Zero
 * <p>
 * Given an integer array nums of size n, return the number with the value closest to 0 in nums. If there are multiple answers, return the number with the largest value.
 * Example 1:
 * <p>
 * Input: nums = [-4,-2,1,4,8]
 * Output: 1
 * Explanation:
 * <ul>
 * <li>The distance from -4 to 0 is |-4| = 4. </li>
 * <li>The distance from -2 to 0 is |-2| = 2. </li>
 * <li>The distance from 1 to 0 is |1| = 1. </li>
 * <li>The distance from 4 to 0 is |4| = 4. </li>
 * <li> The distance from 8 to 0 is |8| = 8. </li>
 * </ul>
 * Thus, the closest number to 0 in the array is 1.
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [2,-1,1]
 * Output: 1
 * <p>
 * Explanation: 1 and -1 are both the closest numbers to 0, so 1 being larger is returned.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 1000
 * -105 <= nums[i] <= 105
 */
public class ClosestNumber {

    private static final Logger log = Logger.getLogger(ClosestNumber.class.getName());

    public static void main(String[] args)
    {
        // Number of nums
        int[] nums = {-2,2};
        log.info(() -> String.format("Min Distance to Zero is : nums: %s, result: %s",
                Arrays.toString(nums), findClosestNumber(nums)));
    }

    public static int findClosestNumber(int[] nums) {
        int minDist = Integer.MAX_VALUE;

        for (int num : nums) {
            if (Math.abs(num) == Math.abs(minDist)) {
                if(num > minDist) {
                    minDist = num;
                }
            } else if (Math.abs(num) < Math.abs(minDist)) {
                minDist = num;
            }
        }

        return minDist;
    }
}
