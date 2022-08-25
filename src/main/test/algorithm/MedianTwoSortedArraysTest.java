package main.test.algorithm;

import static main.java.algorithm.MedianTwoSortedArrays.findMedianSortedArrays;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

public class MedianTwoSortedArraysTest
{
    @TestFactory
    Stream<DynamicTest> dynamicTests() {
        List<List<int[]>> numsArrays = List.of(
            List.of( new int[]{1,2}, new int[] {3,4}),
            List.of( new int[]{1,3}, new int[] {2}),
            List.of( new int[]{900}, new int[]{5, 8, 10, 20}),
            List.of(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
                new int[]{ 11, 12, 13, 14, 15, 16, 17, 18, 19 })
        );
        List<Double> returns = List.of(2.5D, 2D, 10D, 10D);

        List<DynamicTest> dynamicTests = new ArrayList<>();

        for( int idx = 0; idx < numsArrays.size(); idx++) {
            List<int[]> arrays = numsArrays.get(idx);
            double expected = returns.get(idx);
            DynamicTest dynamicTest = dynamicTest("Dynamic Test for findMedianSortedArrays: ", () -> {
                assertEquals(expected, findMedianSortedArrays(arrays.get(0), arrays.get(1)));
            });
            dynamicTests.add(dynamicTest);
        }

        return dynamicTests.stream();
    }
}
