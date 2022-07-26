package main.java.leetCodeProblems.algorithm;

import java.util.Objects;

import main.java.leetCodeProblems.algorithm.common.ListNode;

/**
 * 92. Reverse Linked List II
 *
 * Given the head of a singly linked list and two integers left and right where left <= right, reverse the nodes of the
 * list from position left to position right, and return the reversed list.
 *
 * Example 1:
 * Input: head = [1,2,3,4,5], left = 2, right = 4
 * Output: [1,4,3,2,5]
 *
 * Example 2:
 * Input: head = [5], left = 1, right = 1
 * Output: [5]
 *
 * Constraints:
 * The number of nodes in the list is n.
 * 1 <= n <= 500
 * -500 <= Node.val <= 500
 * 1 <= left <= right <= n
 *
 * Follow up: Could you do it in one pass?
 *
 */
public class ReverseLinkedListII
{

    public static void main(String[] args)
    {
        ListNode head = ListNode.init();
        int left = 2;
        int right = 4;
        ListNode result = reverseBetween(head, left, right);
        result.print();
    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {

        ListNode result = head;
        ListNode prev = null;
        ListNode temp;
        int idx = 1;
        while(idx < left) {
            prev = result;
            result = result.next;
            idx++;
        }
        ListNode con = prev;
        ListNode tail = result;
        int numNodes = right - idx;
        while(numNodes >= 0) {
            temp = result.next;
            result.next = prev;
            prev = result;
            result = temp;
            numNodes--;
        }

        if (Objects.nonNull(con)) {
            con.next = prev;
        } else {
            head = prev;
        }
        tail.next = result;
        return head;
    }


    public static ListNode reverseBetweenSol(ListNode head, int left, int right) {

        // Empty list
        if (Objects.isNull(head)) {
            return null;
        }

        // Move the two pointers until they reach the proper starting point
        // in the list.
        ListNode cur = head;
        ListNode prev = null;
        while (left > 1) {
            prev = cur;
            cur = cur.next;
            left--;
            right--;
        }

        // The two pointers that will fix the final connections.
        ListNode con = prev;
        ListNode tail = cur;

        // Iteratively reverse the nodes until n becomes 0.
        ListNode third;
        while (right > 0) {
            third = cur.next;
            cur.next = prev;
            prev = cur;
            cur = third;
            right--;
        }

        // Adjust the final connections as explained in the algorithm
        if (Objects.nonNull(con)) {
            con.next = prev;
        } else {
            head = prev;
        }

        tail.next = cur;
        return head;
    }
}
