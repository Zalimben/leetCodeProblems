package main.java.algorithm;

import java.util.List;
import java.util.Objects;

import main.java.algorithm.common.ListNode;

/**
 * 2. Add Two Numbers
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order,
 * and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Example 1:
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807.
 *  <p>
 * Example 2:
 * Input: l1 = [0], l2 = [0]
 * Output: [0]
 * <p>
 * Example 3:
 * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * Output: [8,9,9,9,0,0,0,1]
 * <p>
 * Constraints:
 * The number of nodes in each linked list is in the range [1, 100].
 * 0 <= Node.val <= 9
 * It is guaranteed that the list represents a number that does not have leading zeros.
 */
public class AddTwoNumbers
{

    public static void main(String[] args)
    {
        ListNode sum1 = new ListNode(List.of(9,9,9,9,9,9,9));
        ListNode sum2 = new ListNode(List.of(9,9,9,9));
        ListNode result = addTwoNumbers(sum1, sum2);
        result.print();
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int remainder = 0;
        int sumA;
        int sumB;
        int sumR;
        ListNode head = null;
        ListNode tail = null;
        ListNode newNode;
        while(Objects.nonNull(l1)
            || Objects.nonNull(l2) ) {
            sumA = Objects.isNull(l1)  ? 0 : l1.val;
            sumB = Objects.isNull(l2)  ? 0 : l2.val;
            sumR = sumA + sumB + remainder;
            remainder = sumR / 10;
            int digit = sumR % 10;
            if(Objects.isNull(head)) {
                head = new ListNode(digit);
                tail = head;
            } else {
                newNode = new ListNode(digit);
                tail.next = newNode;
                tail = newNode;
            }
            l1 = Objects.isNull(l1)  ? null : l1.next;
            l2 = Objects.isNull(l2)  ? null : l2.next;
        }
        if(remainder > 0) {
            newNode = new ListNode(remainder);
            tail.next = newNode;
        }
        return head;
    }

}
