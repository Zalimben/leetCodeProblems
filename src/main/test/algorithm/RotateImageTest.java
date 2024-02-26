package main.test.algorithm;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static main.java.algorithm.RotateImage.rotateImage;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

public class RotateImageTest {
    @TestFactory
    Stream<DynamicTest> dynamicTests() {
        int[][] imageTest = {
                {1, 1, 1},
                {1, 1, 0},
                {1, 0, 1}
        };
        int[][] imageTest2 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        List<int[][]> testImages = new ArrayList<>();
        testImages.add(imageTest);
        testImages.add(imageTest2);

        List<DynamicTest> dynamicTests = new ArrayList<>();

        for (int idx = 0; idx < testImages.size(); idx++) {
            int[][] image = testImages.get(idx);
            DynamicTest dynamicTest = dynamicTest("Dynamic Test for rotateImage: ", () -> {
                System.out.println();
                System.out.println("**** ****");
                printImage(image);
                rotateImage(image);
                System.out.println();
                printImage(image);
            });
            dynamicTests.add(dynamicTest);
        }
        return dynamicTests.stream();
    }

    private static void printImage(int[][] result) {
        for (int[] rowPaint : result) {
            System.out.println();
            for (int i : rowPaint) {
                System.out.print(i);
                System.out.print(" ");
            }
        }
    }
}
