package main.test.algorithm;

import static main.java.algorithm.ValidAnagram.isAnagram;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import main.java.algorithm.TwoSum;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

class TwoSumTest
{
    @TestFactory
    Stream<DynamicTest> dynamicTests()
    {
        List<List<Integer>> listNums = List.of(
            List.of(2, 7, 11, 15),
            List.of(3, 2, 4),
            List.of(3, 3)
        );
        List<Integer> targets = List.of(
            9, 6, 6
        );
        List<List<Integer>> expectedResult = List.of(
            List.of(0, 1),
            List.of(1, 2),
            List.of(0, 1)
        );
        List<DynamicTest> dynamicTests = new ArrayList<>();

        for(int idx = 0; idx < listNums.size(); idx++) {
            int[] nums = listNums.get(idx).stream().mapToInt(i -> i).toArray();
            int target = targets.get(idx);
            int[] result = expectedResult.get(idx).stream().mapToInt(i -> i).toArray();
            DynamicTest dynamicTest = dynamicTest("Dynamic Test for " + this.getClass() +
                ": Nums: " + Arrays.toString(nums) + "; Target: " + target, () -> {
                int[] resultToCheck = TwoSum.twoSum(nums, target);
                assertEquals(result[0], resultToCheck[0]);
                assertEquals(result[1], resultToCheck[1]);
            });
            dynamicTests.add(dynamicTest);
        }

        return dynamicTests.stream();
    }
}