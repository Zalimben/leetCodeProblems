package main.java.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * 4. Median of Two Sorted Arrays
 * <p>
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
 * The overall run time complexity should be O(log (m+n)).
 * <p>
 * Example 1:
 * Input: nums1 = [1,3], nums2 = [2]
 * Output: 2.00000
 * Explanation: merged array = [1,2,3] and median is 2.
 * <p>
 * Example 2:
 * Input: nums1 = [1,2], nums2 = [3,4]
 * Output: 2.50000
 * Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 * <p>
 * Constraints:
 * nums1.length == m
 * nums2.length == n
 * 0 <= m <= 1000
 * 0 <= n <= 1000
 * 1 <= m + n <= 2000
 * -106 <= nums1[i], nums2[i] <= 106
 */
public class MedianTwoSortedArrays
{
    public static void main(String[] args)
    {
        int[] nums1 = {1,2};
        int[] nums2 = {3,4};
        findMedianSortedArrays(nums1, nums2);

    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        double median = 0D;
        List<Integer> nums = new ArrayList<>();
        nums.addAll(Arrays.stream(nums1).boxed().collect(Collectors.toList()));
        nums.addAll(Arrays.stream(nums2).boxed().collect(Collectors.toList()));
        nums = nums.stream().sorted().collect(Collectors.toList());
        int size = nums.size();
        if(size % 2 == 0) {
            int med = size/2;
            median = (double) (nums.get(med -1) + nums.get(med)) / 2 ;
        } else {
            median = nums.get(size /2);
        }
        return median;
    }
}
