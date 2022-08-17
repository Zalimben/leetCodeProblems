package main.test.algorithm;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import main.java.algorithm.UniqueMorseCodeWords;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

class UniqueMorseCodeWordsTest
{
    @TestFactory
    Stream<DynamicTest> dynamicTests()
    {
        String[] words = {"gin", "zen", "gig", "msg"};
        String[] a = {"a","sos"};
        List<String[]> listOfWords = List.of(
            words, a
        );

        List<Integer> values = List.of(
            2, 2
        );

        List<DynamicTest> dynamicTests = new ArrayList<>();

        for(int idx = 0; idx < listOfWords.size(); idx++) {
            String[] word = listOfWords.get(idx);
            Integer expected = values.get(idx);
            DynamicTest dynamicTest = dynamicTest(
                "Dynamic Test for " + this.getClass() + ": " + Arrays.toString(word), () ->
                    assertEquals(expected, UniqueMorseCodeWords.uniqueMorseRepresentations(word)));
            dynamicTests.add(dynamicTest);
        }

        return dynamicTests.stream();
    }
}