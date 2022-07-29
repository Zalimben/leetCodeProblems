package main.test.algorithm;

import static main.java.algorithm.FloodFill.floodFillRecursive;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.testng.internal.collections.Pair;

class FloodFillTest
{

    @TestFactory
    Stream<DynamicTest> dynamicTests()
    {
        int[][] paint = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        int[][] paint2 = {{0, 0, 0}, {0, 0, 0}};
        int[][] paint3 = {{2, 0}, {0, 2}, {1,1}};
        int[][] paint4 = {{0, 1, 0}, {0, 1, 0}, {0, 1, 0}};
        int[][] paint5 = {{2, 2, 2}, {0, 0, 2}, {0, 0, 2}};
        List<int[][]> testImages = new ArrayList<>();
        testImages.add(paint);
        testImages.add(paint2);
        testImages.add(paint3);
        testImages.add(paint4);
        testImages.add(paint5);

        List<Pair<Integer, Integer>> rowCol = List.of(
            new Pair<>(1, 1),
            new Pair<>(0, 0),
            new Pair<>(1,1),
            new Pair<>(0,1),
            new Pair<>(1,1)
        );

        List<Integer> colors = List.of(
            2, 0, 3, 4, 5
        );
        List<DynamicTest> dynamicTests = new ArrayList<>();

        for(int idx = 0; idx < testImages.size(); idx++) {
            int[][] image = testImages.get(idx);
            int row = rowCol.get(idx).first();
            int col = rowCol.get(idx).second();
            int color = colors.get(idx);
            DynamicTest dynamicTest = dynamicTest("Dynamic Test for floodFill: ", () -> {
                System.out.println();
                System.out.println("**** ****");
                printImage(image);
                int[][] result = floodFillRecursive(image, row, col, color);
                System.out.println();
                printImage(result);
            });
            dynamicTests.add(dynamicTest);
        }
        return dynamicTests.stream();
    }

    private static void printImage(int[][] result)
    {
        for(int[] rowPaint : result) {
            System.out.println();
            for(int i : rowPaint) {
                System.out.print(i);
                System.out.print(" ");
            }
        }
    }
}