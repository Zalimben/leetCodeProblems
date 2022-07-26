package main.java.leetCodeProblems.algorithm;

/**
 * 189. Rotate Array
 * Given an array, rotate the array to the right by k steps, where k is non-negative.
 * <p>
 * Example 1:
 * Input: nums = [1,2,3,4,5,6,7], k = 3
 * Output: [5,6,7,1,2,3,4]
 * Explanation:
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 * <p>
 * Example 2:
 * Input: nums = [-1,-100,3,99], k = 2
 * Output: [3,99,-1,-100]
 * Explanation:
 * rotate 1 steps to the right: [99,-1,-100,3]
 * rotate 2 steps to the right: [3,99,-1,-100]
 * <p>
 * <p>
 * Constraints:
 * 1 <= nums.length <= 105
 * -231 <= nums[i] <= 231 - 1
 * 0 <= k <= 105
 * <p>
 * <p>
 * Follow up:
 * Try to come up with as many solutions as you can. There are at least three different ways to solve this problem.
 * Could you do it in-place with O(1) extra space?
 */
public class RotateArray
{
    public static void main(String[] args)
    {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12};
        int step = 15;
        rotateArray(nums, step);
        for(int num : nums) {
            System.out.print(num);
        }
    }

    private static void rotateArray(int[] nums, int step)
    {
        int[] auxNums = new int[nums.length];
        int newIdx;
        for(int idx = 0; idx < nums.length; idx++) {
            newIdx = idx + step;
            while(newIdx >= auxNums.length) {
                newIdx = newIdx - auxNums.length;
            }
            auxNums[newIdx] = nums[idx];
        }
        System.arraycopy(auxNums, 0, nums, 0, nums.length);
    }
}
