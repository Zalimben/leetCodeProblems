package main.test.algorithm;

import static main.java.algorithm.LongestSubstringWithoutRepeatingChars.longestSubstring;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

class LongestSubstringWithoutRepeatingCharsTest
{

    @TestFactory
    Stream<DynamicTest> dynamicTests() {
        List<String> testStrings = List.of(
            "abcabcbb",
            "bbbbb",
            "pwwkew",
            "au",
            "dvdf"
        );
        List<Integer> solutions = List.of(3, 1, 3, 2, 3);
        List<DynamicTest> dynamicTests = new ArrayList<>();

        for( int idx = 0; idx < testStrings.size(); idx++ ) {
            int expected = solutions.get(idx);
            String s = testStrings.get(idx);
            DynamicTest dynamicTest = dynamicTest("Dynamic Test for numMatchingSubseq: " + s, () -> {
                assertEquals(expected, longestSubstring(s));
            });
            dynamicTests.add(dynamicTest);
        }

        return dynamicTests.stream();
    }
}