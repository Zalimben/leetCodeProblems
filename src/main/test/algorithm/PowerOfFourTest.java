package main.test.algorithm;

import main.java.algorithm.PowerOfFour;
import main.java.algorithm.TwoSum;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

public class PowerOfFourTest {

    @TestFactory
    Stream<DynamicTest> dynamicTests() {
        List<Integer> listNums = List.of(
                16, 64, 0, -16, 1024, 2048
        );

        List<Boolean> expectedResult = List.of(
                true, true, false, false, true, false
        );
        List<DynamicTest> dynamicTests = new ArrayList<>();

        for (int idx = 0; idx < listNums.size(); idx++) {
            int num = listNums.get(idx);
            Boolean result = expectedResult.get(idx);
            DynamicTest dynamicTest = dynamicTest("Dynamic Test for " + this.getClass() +
                    ": Nums: " + num, () -> {
                boolean resultToCheck = PowerOfFour.isPowerOfFour(num);
                assertEquals(resultToCheck, result);
            });
            dynamicTests.add(dynamicTest);
        }

        return dynamicTests.stream();
    }
}
