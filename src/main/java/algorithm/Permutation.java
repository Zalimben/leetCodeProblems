package main.java.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


/**
 * 46. Permutations
 * Given an array nums of distinct integers, return all the possible permutations.
 * You can return the answer in any order.
 *
 * Example 1:
 *
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * Example 2:
 *
 * Input: nums = [0,1]
 * Output: [[0,1],[1,0]]
 * Example 3:
 *
 * Input: nums = [1]
 * Output: [[1]]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 6
 * -10 <= nums[i] <= 10
 * All the integers of nums are unique.
 *
 */
public class Permutation {

    public static void main(String[] args) {
        int[] numsArray = {1,2,3};
        List<List<Integer>> permutationsNums = permut(numsArray);
        System.out.printf("Se encontraron %s permutaciones", permutationsNums.size());
        System.out.println();
        System.out.printf("Matematicamente existen: %d", factorial(numsArray.length));
        System.out.println();
        for ( List<Integer> per : permutationsNums ) {
            System.out.println(per);
        }
    }

    public static List<List<Integer>> permut(int[] nums) {
        List<Integer> numsAsList = IntStream.of(nums).boxed().collect(Collectors.toList());
        List<List<Integer>> generatedPermutations = new ArrayList<>();
        generatedPermutations.add( new ArrayList<>(numsAsList));
        int length = numsAsList.size();
        Integer[] aux = new Integer[length];
        Arrays.fill(aux, 0);
        int idx = 0;
        while (idx < length) {
            if (aux[idx] < idx) {
                if (idx % 2 == 0) {
                    swapElements(numsAsList, 0, idx);
                } else {
                    swapElements(numsAsList, aux[idx], idx);
                }
                generatedPermutations.add( new ArrayList<>(numsAsList));
                aux[idx] = aux[idx] + 1;
                idx = 0;
            } else {
                aux[idx] = 0;
                idx++;
            }
        }

        return generatedPermutations;
    }

    public static void swapElements(List<Integer> arr, int index1, int index2) {
        Collections.swap(arr, index1, index2);
    }

    public static int factorial (int n) {

        int producto = 1;
        if (n == 0 || n == 1) {
            return 1;
        }
        for (int i = 1; i <= n; ++i) {
            producto *= i;
        }
        return producto;

    }

}
