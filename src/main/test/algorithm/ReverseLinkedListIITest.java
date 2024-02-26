package main.test.algorithm;

import main.java.algorithm.common.ListNode;
import main.java.algorithm.utils.Pair;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static main.java.algorithm.ReverseLinkedListII.reverseBetween;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

class ReverseLinkedListIITest {
    @TestFactory
    Stream<DynamicTest> dynamicTests() {
        List<List<Integer>> testIntegers = List.of(
                List.of(1, 2, 3, 4, 5),
                List.of(3, 1, 3, 2, 3),
                List.of(1, 4, 3, 2, 5, 2),
                List.of(2, 1),
                List.of(8, -9, 2, 4, 5, 6, 5, 18, -44, 9)
        );
        List<Pair<Integer, Integer>> values = List.of(
                new Pair<>(2, 4),
                new Pair<>(2, 4),
                new Pair<>(2, 5),
                new Pair<>(1, 2),
                new Pair<>(1, 7)
        );
        List<DynamicTest> dynamicTests = new ArrayList<>();

        for (int idx = 0; idx < testIntegers.size(); idx++) {
            List<Integer> list = testIntegers.get(idx);
            ListNode head = new ListNode(list);
            Pair<Integer, Integer> integerIntegerPair = values.get(idx);
            Integer left = integerIntegerPair.first();
            Integer right = integerIntegerPair.second();
            DynamicTest dynamicTest = dynamicTest("Dynamic Test for reverseBetween: " + integerIntegerPair, () -> {
                ListNode result = reverseBetween(head, left, right);
                result.print();
                assertNotNull(result);
            });
            dynamicTests.add(dynamicTest);
        }

        return dynamicTests.stream();
    }
}