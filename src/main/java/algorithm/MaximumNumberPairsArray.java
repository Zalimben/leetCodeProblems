package main.java.algorithm;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 2341. Maximum Number of Pairs in Array
 * <p>
 * You are given a 0-indexed integer array nums. In one operation, you may do the following:
 * - Choose two integers in nums that are equal.
 * - Remove both integers from nums, forming a pair.
 * The operation is done on nums as many times as possible.
 * <p>
 * Return a 0-indexed integer array answer of size 2 where answer[0] is the number of pairs that are formed and answer[1]
 * is the number of leftover integers in nums after doing the operation as many times as possible.
 * <p>
 * Example 1:
 * Input: nums = [1,3,2,1,3,2,2]
 * Output: [3,1]
 * Explanation:
 * Form a pair with nums[0] and nums[3] and remove them from nums. Now, nums = [3,2,3,2,2].
 * Form a pair with nums[0] and nums[2] and remove them from nums. Now, nums = [2,2,2].
 * Form a pair with nums[0] and nums[1] and remove them from nums. Now, nums = [2].
 * No more pairs can be formed. A total of 3 pairs have been formed, and there is 1 number leftover in nums.
 * <p>
 * Example 2:
 * Input: nums = [1,1]
 * Output: [1,0]
 * Explanation: Form a pair with nums[0] and nums[1] and remove them from nums. Now, nums = [].
 * No more pairs can be formed. A total of 1 pair has been formed, and there are 0 numbers leftover in nums.
 * <p>
 * Example 3:
 * Input: nums = [0]
 * Output: [0,1]
 * Explanation: No pairs can be formed, and there is 1 number leftover in nums.
 * <p>
 * Constraints:
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 100
 */
public class MaximumNumberPairsArray
{
    public static void main(String[] args)
    {
        List<int[]> arrays = new ArrayList<>();
        int[] numsA = {1,3,2,1,3,2,2};
        int[] numsB = {1,1};
        int[] numsC = {0};
        arrays.add(numsA);
        arrays.add(numsB);
        arrays.add(numsC);
        arrays.forEach( x -> {
            int[] solution = numberOfPairs(x);
            for(int y : solution) {
                System.out.println(y);
            }
            System.out.println();
        });

    }

    public static int[] numberOfPairs(int[] nums) {

        int numPairs = 0;
        int numLeftOvers = 0;

        int num = nums[0];
        int countNum = 0;
        Arrays.sort(nums);
        int idx = 0;
        while (idx < nums.length) {
            if(nums[idx] == num) {
                countNum++;
                idx++;
            } else {
                if(countNum % 2 == 0) {
                    numPairs += countNum / 2;
                } else {
                    numPairs += countNum / 2;
                    numLeftOvers++;
                }
                countNum = 0;
                num = nums[idx];
            }
        }
        // Process last element
        if(countNum % 2 == 0) {
            numPairs += countNum / 2;
        } else {
            numPairs += countNum / 2;
            numLeftOvers++;
        }
        return new int[]{numPairs,numLeftOvers};
    }

    public static int[] numberOfPairsImprove(int[] nums) {
        Arrays.sort(nums);
        int numPairs = 0;
        for (int i = 0; i < nums.length - 1; i += 2) {
            if (nums[i] == nums[i + 1]) {
                numPairs++;
            } else {
                i--;
            }
        }
        return new int[]{numPairs, nums.length - (numPairs * 2)};
    }



}
