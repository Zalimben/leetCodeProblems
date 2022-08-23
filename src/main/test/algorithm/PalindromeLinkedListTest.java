package main.test.algorithm;

import static main.java.algorithm.PalindromeLinkedList.isPalindrome;
import static main.java.algorithm.PartitionList.partition;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import main.java.algorithm.PalindromeLinkedList;
import main.java.algorithm.common.ListNode;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

public class PalindromeLinkedListTest
{
    @TestFactory
    Stream<DynamicTest> dynamicTests() {
        List<List<Integer>> testIntegers = List.of(
            List.of(1,2,3,4,5,6,7,8,9,8,7,6,5,4,3,2,1),
            List.of(1, 4, 3, 2, 5, 2),
            List.of(1, 2, 1),
            List.of(8, 9, 2, 4,5,6,5,18,44,9)
        );
        List<Boolean> expectedValues = List.of(true, false, true, false);
        List<DynamicTest> dynamicTests = new ArrayList<>();

        for( int idx = 0; idx < testIntegers.size(); idx++ ) {
            List<Integer> list = testIntegers.get(idx);
            ListNode head = new ListNode(list);
            Boolean expected = expectedValues.get(idx);
            DynamicTest dynamicTest = dynamicTest("Dynamic Test for isPalindrome: " + idx, () -> {
                assertEquals(isPalindrome(head), expected); ;
            });
            dynamicTests.add(dynamicTest);
        }

        return dynamicTests.stream();
    }
}
