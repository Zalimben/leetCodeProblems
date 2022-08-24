package main.test.algorithm;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import main.java.algorithm.PowerOfThree;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

public class PowerOfThreeTest
{
    @TestFactory
    Stream<DynamicTest> dynamicTests() {
        List<Integer> listNums = List.of(
            16, 27, 0, 9, 93, 3,243
        );

        List<Boolean> expectedResult = List.of(
            false, true, false, true, false, true, true
        );
        List<DynamicTest> dynamicTests = new ArrayList<>();

        for (int idx = 0; idx < listNums.size(); idx++) {
            int num = listNums.get(idx);
            Boolean result = expectedResult.get(idx);
            DynamicTest dynamicTest = dynamicTest("Dynamic Test for " + this.getClass() +
                ": Nums: " + num, () -> {
                boolean resultToCheck = PowerOfThree.isPowerOfThree(num);
                assertEquals(resultToCheck, result);
            });
            dynamicTests.add(dynamicTest);
        }

        return dynamicTests.stream();
    }
}
