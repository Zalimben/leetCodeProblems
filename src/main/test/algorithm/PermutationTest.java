package main.test.algorithm;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static main.java.algorithm.Permutation.permut;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

public class PermutationTest {

    @TestFactory
    Stream<DynamicTest> dynamicTestsExample() {
        List<int[]> permutationInteger = List.of(
                new int[]{1, 2, 3},
                new int[]{1,2},
                new int[]{1,2,3,4}
        );
        List<Boolean> solutions = List.of(true, false, true, true, true, true, false, true, false);
        List<DynamicTest> dynamicTests = new ArrayList<>();

        for( int idx = 0; idx < permutationInteger.size(); idx++ ) {
            int[] nums = permutationInteger.get(idx);
            DynamicTest dynamicTest = dynamicTest("Dynamic Test for Permutation Integer: (" + Arrays.toString(nums) + ")", () ->
                    System.out.println(permut(nums))
            );
            dynamicTests.add(dynamicTest);
        }
        return dynamicTests.stream();
    }

}
