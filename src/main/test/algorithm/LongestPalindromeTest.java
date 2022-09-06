package main.test.algorithm;

import static main.java.algorithm.LongestPalindrome.longestPalSubstringAroundCenter;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

public class LongestPalindromeTest
{
    @TestFactory
    Stream<DynamicTest> dynamicTests() {
        List<String> testStrings = List.of(
            "daabddfddbegtd",
            "babad",
            "cbbd",
            "au",
            "dvdf"
        );
        List<String> solutions = List.of("bddfddb", "aba", "bb", "u", "dvd");
        List<DynamicTest> dynamicTests = new ArrayList<>();

        for( int idx = 0; idx < testStrings.size(); idx++ ) {
            String expected = solutions.get(idx);
            String s = testStrings.get(idx);
            DynamicTest dynamicTest = dynamicTest("Dynamic Test for LongestPalindrome: " + s, () -> {
                assertEquals(expected, longestPalSubstringAroundCenter(s));
            });
            dynamicTests.add(dynamicTest);
        }

        return dynamicTests.stream();
    }
}
