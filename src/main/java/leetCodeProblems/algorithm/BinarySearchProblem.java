package main.java.leetCodeProblems.algorithm;


/**
 * Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to
 * search target in nums. If target exists, then return its index. Otherwise, return -1.
 * You must write an algorithm with O(log n) runtime complexity.
 * <p>
 * Example 1:
 * Input: nums = [-1,0,3,5,9,12], target = 9
 * Output: 4
 * Explanation: 9 exists in nums and its index is 4
 * <p>
 * Example 2:
 * Input: nums = [-1,0,3,5,9,12], target = 2
 * Output: -1
 * Explanation: 2 does not exist in nums so return -1
 * <p>
 * Constraints:
 * 1 <= nums.length <= 104
 * -104 < nums[i], target < 104
 * All the integers in nums are unique.
 * nums is sorted in ascending order.
 */
public class BinarySearchProblem
{
    public static void main(String[] args)
    {
        // Number of versions
        int[] versions = {-1, 0, 3, 5, 9, 12};
        int target = 13;
        System.out.println(search(versions, target));
    }

    public static int search(int[] nums, int target)
    {
        return binarySearch(nums, target, 0, nums.length - 1);
    }

    private static int binarySearch(int[] nums, int target, int min, int max)
    {
        if(min <= max) {
            int mid = min + (max - min) / 2;
            if(target == nums[mid]) {
                return mid;
            }
            if(target > nums[mid]) {
                return binarySearch(nums, target, mid + 1, max);
            }
            return binarySearch(nums, target, min, mid - 1);
        }
        return -1;
    }
}