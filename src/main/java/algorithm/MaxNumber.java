package main.java.algorithm;

public class MaxNumber
{
    public static void main(String[] args)
    {
        int[] nums = {1, 9, 2, 1, 3, 2, 7};
        int result = max(nums);
        System.out.println("The Max element is: " + nums[result] + " and index is: " + result);
    }

    public static int max(int[] nums)
    {
        int max = 0;
        int idx = 0;
        if(nums.length == 0) {
            return -1;
        }

        while(idx < nums.length) {
            if(nums[idx] > nums[max]) {
                max = idx;
            }
            idx++;
        }
        return max;
    }

}
