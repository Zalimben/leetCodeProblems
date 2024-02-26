package main.test.algorithm;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static main.java.algorithm.PalindromeNumber.isNumberPalindrome;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

public class PalindromeTest {

    @TestFactory
    Stream<DynamicTest> dynamicTests() {
        List<Integer> testIntegers = List.of(121, 1221, -121, 123445321, 10, 5);
        List<Boolean> expectedValues = List.of(true, true, false, false, false, true );
        List<DynamicTest> dynamicTests = new ArrayList<>();

        for( int idx = 0; idx < testIntegers.size(); idx++ ) {
            Integer numberIsPalindrome = testIntegers.get(idx);
            Boolean expected = expectedValues.get(idx);
            DynamicTest dynamicTest = dynamicTest("Dynamic Test for isPalindrome: " + idx, () ->
                assertEquals(isNumberPalindrome(numberIsPalindrome), expected)
            );
            dynamicTests.add(dynamicTest);
        }

        return dynamicTests.stream();
    }

}
