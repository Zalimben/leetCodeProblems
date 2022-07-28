package main.test.algorithm;

import static main.java.algorithm.ValidAnagram.isAnagram;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

class ValidAnagramTest
{
    @TestFactory
    Stream<DynamicTest> dynamicTests()
    {
        List<String> isAnagram = List.of(
            "anagram",
            "rat",
            "cornisa",
            "acuerdo",
            "",
            "abc"
        );
        List<String> sources = List.of(
            "nagaram",
            "car",
            "narciso",
            "ecuador",
            "a",
            "a"
        );
        List<Boolean> expectedResult = List.of(true, false, true, true, false, false);
        List<DynamicTest> dynamicTests = new ArrayList<>();

        for(int idx = 0; idx < isAnagram.size(); idx++) {
            String word = isAnagram.get(idx);
            String source = sources.get(idx);
            Boolean expected = expectedResult.get(idx);
            DynamicTest dynamicTest = dynamicTest("Dynamic Test for isAnagram: "+ word + ":" + source , () ->
                assertEquals(expected, isAnagram(word, source))
            );
            dynamicTests.add(dynamicTest);
        }

        return dynamicTests.stream();
    }
}