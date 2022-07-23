package main.java.leetCodeProblems.algorithm;

import main.java.leetCodeProblems.algorithm.common.ListNode;

/**
 * Given the head of a singly linked list, return the middle node of the linked list.
 * If there are two middle nodes, return the second middle node.
 *
 * Example 1:
 * Input: head = [1,2,3,4,5]
 * Output: [3,4,5]
 * Explanation: The middle node of the list is node 3.
 *
 * Example 2:
 * Input: head = [1,2,3,4,5,6]
 * Output: [4,5,6]
 * Explanation: Since the list has two middle nodes with values 3 and 4, we return the second one.
 *
 * Constraints:
 * The number of nodes in the list is in the range [1, 100].
 *
 */
public class MiddleOfLinkedList
{
    public static void main(String[] args)
    {
        ListNode head = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);
        head.print();
        head.next = second;
        second.next = third;
        third.next = four;
        four.next = five;

        ListNode result = middleNode(head);
        result.print();
    }

    private static ListNode middleNode(ListNode head)
    {
        int numNode = 0;
        int midNode;
        ListNode headAux = head;
        // Count number of nodes
        while(headAux != null ) {
            headAux = headAux.next;
            numNode++;
        }
        midNode = (numNode / 2) + 1;
        numNode = 0;
        ListNode midListNode = null;
        while(head != null ) {
            numNode++;
            if(midNode == numNode) {
                midListNode = head;
            }
            head = head.next;
        }
        return midListNode;
    }

}
