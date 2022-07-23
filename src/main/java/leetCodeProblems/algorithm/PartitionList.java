package main.java.leetCodeProblems.algorithm;

import java.util.Objects;

import main.java.leetCodeProblems.algorithm.common.ListNode;

/**
 * 86. Partition List
 *
 * Given the head of a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 * You should preserve the original relative order of the nodes in each of the two partitions.
 *
 * Example 1:
 * Input: head = [1,4,3,2,5,2], x = 3
 * Output: [1,2,2,4,3,5]
 *
 * Example 2:
 * Input: head = [2,1], x = 2
 * Output: [1,2]
 *
 * Constraints:
 * The number of nodes in the list is in the range [0, 200].
 * -100 <= Node.val <= 100
 * -200 <= x <= 200
 */
public class PartitionList
{

    public static void main(String[] args)
    {
        ListNode result = partition(ListNode.init(), 3);
        result.print();
    }

    public static ListNode partition(ListNode head, int x) {
        ListNode less = null;
        ListNode big = null;

        while (Objects.nonNull(head)) {
            int val = head.val;
            if(val < x) {
                if(Objects.isNull(less)) {
                    less = new ListNode(val);
                } else {
                    ListNode.addNodeValue(less, val);
                }
            } else {
                if(Objects.isNull(big)) {
                    big = new ListNode(val);
                } else {
                    ListNode.addNodeValue(big, val);
                }
            }
            head = head.next;
        }

        // ListNode.addNode(less, big);
        ListNode result = less;
        if(Objects.isNull(less)) {
            result = big;
        } else {
            while (Objects.nonNull(less.next)) {
                less = less.next;
            }
            less.next = big;
        }
        return result;
    }

}
