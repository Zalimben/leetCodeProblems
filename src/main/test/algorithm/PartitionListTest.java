package main.test.algorithm;

import static main.java.leetCodeProblems.algorithm.PartitionList.partition;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import main.java.leetCodeProblems.algorithm.common.ListNode;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

class PartitionListTest
{
    @TestFactory
    Stream<DynamicTest> dynamicTestsExample() {
        List<List<Integer>> testIntegers = List.of(
            List.of(3, 1, 3, 2, 3),
            List.of(1,4,3,2,5,2),
            List.of(2,1),
            List.of(8, -9, 2, 4,5,6,5,18,-44,9)
        );
        List<Integer> pivotValues = List.of(3, 3, 2, 5);
        List<DynamicTest> dynamicTests = new ArrayList<>();

        for( int idx = 0; idx < testIntegers.size(); idx++ ) {
            List<Integer> list = testIntegers.get(idx);
            ListNode head = new ListNode(list);
            Integer pivot = pivotValues.get(idx);
            DynamicTest dynamicTest = dynamicTest("Dynamic Test for PartitionListTest: " + idx, () -> {
                ListNode result = partition(head, pivot);
                result.print();
                assertNotNull(result);
            });
            dynamicTests.add(dynamicTest);
        }

        return dynamicTests.stream();
    }

    @Test
    void emptyListNode() {
        ListNode head = new ListNode();
        ListNode result = partition(head, 0);
        result.print();
    }
}