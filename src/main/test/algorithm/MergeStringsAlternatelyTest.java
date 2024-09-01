package main.test.algorithm;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static main.java.algorithm.MergeStringsAlternately.mergeAlternately;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

public class MergeStringsAlternatelyTest {

    @TestFactory
    Stream<DynamicTest> dynamicTests() {
        List<String> inputWord1 = List.of(
                "abc",
                "ab",
                "abcd",
                "b",
                "c",
                "xyz",
                "",
                "abc"
        );

        List<String> inputWord2 = List.of(
                "pqr",
                "pqrs",
                "pq",
                "b",
                "c",
                "abc",
                "null",
                "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz"
        );

        List<String> returns = List.of(
                "apbqcr", "apbqrs", "apbqcd", "bb", "cc", "xaybzc", "", "");

        List<DynamicTest> dynamicTests = new ArrayList<>();

        for (int idx = 0; idx < inputWord1.size(); idx++) {
            String word1 = inputWord1.get(idx);
            String word2 = inputWord2.get(idx);
            String expected = returns.get(idx);

            DynamicTest dynamicTest = dynamicTest("Dynamic Test for Merge Strings Alternately: "
                    + String.format("Word1: %s Word2: %s", word1, word2), () ->
                assertEquals(expected, mergeAlternately(word1, word2))
            );
            dynamicTests.add(dynamicTest);
        }

        return dynamicTests.stream();
    }

}
