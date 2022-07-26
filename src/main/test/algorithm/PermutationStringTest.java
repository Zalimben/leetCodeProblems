package main.test.algorithm;

import static main.java.algorithm.PermutationString.isPermutation;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

class PermutationStringTest
{

    @TestFactory
    Stream<DynamicTest> dynamicTestsExample() {
        List<String> testStrings = List.of(
            "abcabcbb",
            "bbbbb",
            "pwwkew",
            "au",
            "dvdf",
            "eidbaooo",
            "eidboaoo",
            "a",
            "asd"
        );
        List<String> permutationString = List.of(
            "ac",
            "cc",
            "wek",
            "a",
            "fd",
            "ab",
            "ab",
            "a",
            "asdf"
        );
        List<Boolean> solutions = List.of(true, false, true, true, true, true, false, true, false);
        List<DynamicTest> dynamicTests = new ArrayList<>();

        for( int idx = 0; idx < testStrings.size(); idx++ ) {
            boolean expected = solutions.get(idx);
            String s = testStrings.get(idx);
            String per = permutationString.get(idx);
            DynamicTest dynamicTest = dynamicTest("Dynamic Test for isPermutation: (" + per + ", " + s +")", () -> {
                assertEquals(expected, isPermutation(per, s));
            });
            dynamicTests.add(dynamicTest);
        }

        return dynamicTests.stream();
    }
}