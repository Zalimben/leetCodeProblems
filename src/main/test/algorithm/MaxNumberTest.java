package main.test.algorithm;

import static main.java.algorithm.MaxNumber.max;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

class MaxNumberTest
{
    @TestFactory
    Stream<DynamicTest> dynamicTests()
    {

        List<int[]> numsArrays = List.of(
            new int[]{1, 3, 2, 1, 3, 2, 9},
            new int[]{1, 1},
            new int[]{0},
            new int[]{9, 9, 88, 87, 90, 3},
            new int[]{}
        );
        List<Integer> expected = List.of(
            6, 0, 0, 4, -1
        );

        List<DynamicTest> dynamicTests = new ArrayList<>();

        for(int idx = 0; idx < numsArrays.size(); idx++) {
            int[] array = numsArrays.get(idx);
            int expectedValue = expected.get(idx);
            DynamicTest dynamicTest = dynamicTest("Dynamic Test for MaxNumber: ", () -> {
                System.out.println("#### #### ####");
                int resultFunc = max(array);
                assertEquals(expectedValue, resultFunc);
                System.out.println(Arrays.toString(array));
                if(expectedValue >= 0) {
                    System.out.println("The Max element is: " + array[expectedValue] + " and index is: " + expectedValue);
                } else {
                    System.out.println("Array is empty");
                }
            });
            dynamicTests.add(dynamicTest);
        }

        return dynamicTests.stream();
    }
}