package main.java.algorithm;

import java.util.Arrays;

/**
 * 167. Two Sum II - Input Array Is Sorted
 * <p>
 * Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers such that
 * they add up to a specific target number. Let these two numbers be numbers[index1] and numbers[index2]
 * where 1 <= index1 < index2 <= numbers.length.
 * Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.
 * The tests are generated such that there is exactly one solution. You may not use the same element twice.
 * Your solution must use only constant extra space.
 * <p>
 * Example 1:
 * Input: numbers = [2,7,11,15], target = 9
 * Output: [1,2]
 * Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].
 * <p>
 * Example 2:
 * Input: numbers = [2,3,4], target = 6
 * Output: [1,3]
 * Explanation: The sum of 2 and 4 is 6. Therefore, index1 = 1, index2 = 3. We return [1, 3].
 * <p>
 * Example 3:
 * Input: numbers = [-1,0], target = -1
 * Output: [1,2]
 * Explanation: The sum of -1 and 0 is -1. Therefore, index1 = 1, index2 = 2. We return [1, 2].
 * <p>
 * <p>
 * Constraints:
 * 2 <= numbers.length <= 3 * 104
 * -1000 <= numbers[i] <= 1000
 * numbers is sorted in non-decreasing order.
 * -1000 <= target <= 1000
 * The tests are generated such that there is exactly one solution.
 */
public class TwoSumII
{
    public static void main(String[] args)
    {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        System.out.println(Arrays.toString(twoSumSol2(nums, target)));
    }

    private static int[] twoSumSol(int[] nums, int target)
    {
        int aux;
        int[] sol = {0, 0};
        for(int idx = 0; idx < nums.length; idx++) {
            aux = target - nums[idx];
            for(int idx2 = idx; idx2 < nums.length; idx2++) {
                if(nums[idx2] == aux && idx != idx2) {
                    sol[0] = idx + 1;
                    sol[1] = idx2 + 1;
                    break;
                }
            }
        }
        return sol;
    }

    private static int[] twoSumSol2(int[] nums, int target)
    {
        int start = 0, n = nums.length, end = n - 1;
        while(start <= end) {
            if(nums[start] + nums[end] == target) {
                return new int[]{start + 1, end + 1};
            } else if(nums[start] + nums[end] < target) {
                start++;
            } else {
                end--;
            }
        }
        return new int[]{};
    }
}
