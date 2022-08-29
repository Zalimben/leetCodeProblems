package main.test.algorithm;

import static main.java.algorithm.NumberOfIsland.numberOfIsland;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

public class NumberOfIslandTest
{
    @TestFactory
    Stream<DynamicTest> dynamicTests() {
        List<char[][]> listOfMaps = List.of(
            new char[][] {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}},
            new char[][] {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '1'}},
            new char[][] {
                {'1', '1', '1', '0', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '0', '0', '0', '0'},
                {'0', '0', '0', '1', '1'}},
            new char[][] {
                {'1'}
            }
        );
        List<Integer> expectedValues = List.of(1, 2, 3, 1);
        List<DynamicTest> dynamicTests = new ArrayList<>();

        for( int idx = 0; idx < listOfMaps.size(); idx++ ) {
            char[][] map = listOfMaps.get(idx);
            Integer expected = expectedValues.get(idx);
            DynamicTest dynamicTest = dynamicTest("Dynamic Test for NumberOfIsland: " + idx, () -> {
                assertEquals(numberOfIsland(map), expected);
            });
            dynamicTests.add(dynamicTest);
        }

        return dynamicTests.stream();
    }
}
