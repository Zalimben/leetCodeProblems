package main.java.algorithm;

import java.util.Arrays;

/**
 * 977. Squares of a Sorted Array
 *
 * Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.
 * <p>
 * Example 1:
 * Input: nums = [-4,-1,0,3,10]
 * Output: [0,1,9,16,100]
 * Explanation: After squaring, the array becomes [16,1,0,9,100].
 * After sorting, it becomes [0,1,9,16,100].
 * <p>
 * Example 2:
 * Input: nums = [-7,-3,2,3,11]
 * Output: [4,9,9,49,121]
 * <p>
 * Constraints:
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums is sorted in non-decreasing order.
 */
public class SquaresSortedArray
{
    public static void main(String[] args)
    {

        int[] nums = {-7, -3, 2, 3, 11};
        squaresSortedArray(nums);
    }

    private static void squaresSortedArray(int[] nums)
    {
        for(int idx = 0; idx < nums.length; idx++) {
            nums[idx] = nums[idx] * nums[idx];
        }
        Arrays.sort(nums); // Sorting by DualPivotQuicksort
        for(int num : nums) {
            System.out.println(num);
        }
    }

}
