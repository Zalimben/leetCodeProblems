package main.java.algorithm;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

/**
 * 658. Find K Closest Elements
 * Given a sorted integer array arr, two integers k and x, return the k closest integers to x in the array. The result should also be sorted in ascending order.
 * <p>
 * An integer a is closer to x than an integer b if:
 * <p>
 * |a - x| < |b - x|, or
 * |a - x| == |b - x| and a < b
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: arr = [1,2,3,4,5], k = 4, x = 3
 * Output: [1,2,3,4]
 * <p>
 * Example 2:
 * <p>
 * Input: arr = [1,2,3,4,5], k = 4, x = -1
 * Output: [1,2,3,4]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= k <= arr.length
 * 1 <= arr.length <= 104
 * arr is sorted in ascending order.
 * -104 <= arr[i], x <= 104
 */
public class FindKClosestElements {
    private static final Logger log = Logger.getLogger(FindKClosestElements.class.getName());

    public static void main(String[] args)
    {
        // Number of nums
        int[] nums = {4,5,10,20,30};
        int k = 3;
        int x = 6;
        log.info(() -> String.format("K Closest Elements: nums: %s, k: %d, x: %d, result: %s",
                Arrays.toString(nums), k, x, findKClosestElements(nums, k, x)));
    }

    public static List<Integer> findKClosestElements(int[] nums, int k, int x) {
        List<Integer> result = new ArrayList<>();
        int front = 0;
        int back = nums.length - 1;
        while (back - front >= k) {
            if (Math.abs(nums[front] - x) > Math.abs(nums[back] - x)) {
                front++;
            } else {
                back--;
            }
        }
        for (int idx = front; idx <= back; idx++) {
            result.add(nums[idx]);
        }
        return result;
    }


}
