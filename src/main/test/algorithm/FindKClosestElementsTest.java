package main.test.algorithm;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static main.java.algorithm.FindKClosestElements.findKClosestElements;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

public class FindKClosestElementsTest {

    @TestFactory
    Stream<DynamicTest> dynamicTests() {
        List<int[]> testNums = List.of(
                new int[]{1,2,3,4,5},
                new int[]{1,2,3,4,5},
                new int[]{4,5,10,20,30}
        );
        List<Integer> testKs = List.of(
                4,4,3
        );
        List<Integer> testXs = List.of(
                3,-1,6
        );

        List<List<Integer>> solutions = List.of(
                List.of(1,2,3,4),
                List.of(1,2,3,4),
                List.of(4,5,10)
        );
        List<DynamicTest> dynamicTests = new ArrayList<>();

        for (int idx = 0; idx < testNums.size(); idx++) {
            List<Integer> expected = solutions.get(idx);
            int[] array = testNums.get(idx);
            int k = testKs.get(idx);
            int x = testXs.get(idx);
            DynamicTest dynamicTest = dynamicTest("Dynamic Test for Closest K Elements: " + Arrays.toString(array), () ->
                    assertEquals(expected, findKClosestElements(array, k, x))
            );
            dynamicTests.add(dynamicTest);
        }

        return dynamicTests.stream();
    }

}
