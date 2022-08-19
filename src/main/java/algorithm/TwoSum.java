package main.java.algorithm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1. Two Sum
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * <p>
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * You can return the answer in any order.
 * <p>
 * Example 1:
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 * <p>
 * Example 2:
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 * <p>
 * Example 3:
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 * <p>
 * Constraints:
 * 2 <= nums.length <= 104
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 * Only one valid answer exists.
 *
 */
public class TwoSum
{
    public static void main(String[] args)
    {
        int[] nums = {2,7,11,15};
        int target = 9;
        System.out.println(Arrays.toString(twoSumBruteForce(nums, target)));
    }

    /**
     * Using map data structure (HashMap) and store number and its index as key-value pairs.
     * Using a loop we need to traverse and find in the map if target-current value exist as key or not,
     * - If it exists then we have to add these indices in the list and return it.
     * - Otherwise we need to add this element and its index in the map.
     */
    public static int[] twoSum(int[] nums, int target)
    {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int key = target - nums[i];
            if (map.containsKey(key)) {
                return new int[]{map.get(key), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{-1,-1};
    }

    /**
     * Brute Force
     * Using nested loop to check all elements
     */
    public static int[] twoSumBruteForce(int[] nums, int target) {
        for(int idx = 0; idx < nums.length; idx++) {
            for(int idx2 = idx +1; idx2 < nums.length; idx2++) {
                if(nums[idx] + nums[idx2] == target ) {
                    return new int[]{idx, idx2};
                }
            }
        }
        return new int[]{-1,-1};
    }

}
