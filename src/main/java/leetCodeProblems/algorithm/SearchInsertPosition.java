package main.java.leetCodeProblems.algorithm;

/**
 * Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return
 * the index where it would be if it were inserted in order.
 * You must write an algorithm with O(log n) runtime complexity.
 * <p>
 * Example 1:
 * Input: nums = [1,3,5,6], target = 5
 * Output: 2
 * <p>
 * Example 2:
 * Input: nums = [1,3,5,6], target = 2
 * Output: 1
 * <p>
 * Example 3:
 * Input: nums = [1,3,5,6], target = 7
 * Output: 4
 * <p>
 * Constraints:
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums contains distinct values sorted in ascending order.
 * -104 <= target <= 104
 */
public class SearchInsertPosition
{

    public static void main(String[] args)
    {
        int[] nums = {1, 3, 5, 8, 9};
        int target = 0;
        System.out.println(findBinarySearch(nums, target, 0, nums.length - 1));
    }

    private static int findBinarySearch(int[] nums, int target, int low, int high)
    {
        int mid;
        if(low <= high) {
            mid = low + (high - low) / 2;
            if(target == nums[mid]) {
                return mid;
            }
            if(target > nums[mid]) {
                return findBinarySearch(nums, target, mid + 1, high);
            }
            return findBinarySearch(nums, target, low, mid - 1);
        }
        return low;
    }

}
