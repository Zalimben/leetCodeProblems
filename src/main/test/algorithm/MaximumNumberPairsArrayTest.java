package main.test.algorithm;

import static main.java.algorithm.MaximumNumberPairsArray.numberOfPairs;
import static main.java.algorithm.MaximumNumberPairsArray.numberOfPairsImprove;
import static main.java.algorithm.MedianTwoSortedArrays.findMedianSortedArrays;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

class MaximumNumberPairsArrayTest
{

    @TestFactory
    Stream<DynamicTest> dynamicTests() {

        List<int[]> numsArrays = List.of(
            new int[]{1,3,2,1,3,2,2},
            new int[]{1,1},
            new int[]{0},
            new int[]{9,9,88,87,90,3}
        );
        List<int[]> expected = List.of(
            new int[]{3,1},
            new int[]{1,0},
            new int[]{0,1},
            new int[]{1,4}
        );

        List<DynamicTest> dynamicTests = new ArrayList<>();

        for( int idx = 0; idx < numsArrays.size(); idx++) {
            int[] array = numsArrays.get(idx);
            int[] expectedArray = expected.get(idx);
            DynamicTest dynamicTest = dynamicTest("Dynamic Test for numberOfPairs: ", () -> {
                int[] resultFunc = numberOfPairsImprove(array);
                assertEquals(expectedArray[0], resultFunc[0]);
                assertEquals(expectedArray[1], resultFunc[1]);
            });
            dynamicTests.add(dynamicTest);
        }

        return dynamicTests.stream();
    }

}