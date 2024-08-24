package main.test.algorithm;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static main.java.algorithm.ClosestNumber.findClosestNumber;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

public class ClosestNumberTest {

    @TestFactory
    Stream<DynamicTest> dynamicTests() {
        List<int[]> testNums = List.of(
                new int[]{-4, -2, 1, 4, 8},
                new int[]{2,-1,1},
                new int[]{2,-1,0},
                new int[]{-2,-1,3}
        );
        List<Integer> solutions = List.of(1, 1, 0, -1);
        List<DynamicTest> dynamicTests = new ArrayList<>();

        for (int idx = 0; idx < testNums.size(); idx++) {
            Integer expected = solutions.get(idx);
            int[] array = testNums.get(idx);
            DynamicTest dynamicTest = dynamicTest("Dynamic Test for Closest Number: " + Arrays.toString(array), () ->
                assertEquals(expected, findClosestNumber(array))
            );
            dynamicTests.add(dynamicTest);
        }

        return dynamicTests.stream();
    }
}

