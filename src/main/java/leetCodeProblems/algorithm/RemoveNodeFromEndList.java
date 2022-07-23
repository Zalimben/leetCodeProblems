package main.java.leetCodeProblems.algorithm;

import main.java.leetCodeProblems.algorithm.common.ListNode;

/**
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 *
 * Example 1:
 * Input: head = [1,2,3,4,5], n = 2
 * Output: [1,2,3,5]
 *
 * Example 2:
 * Input: head = [1], n = 1
 * Output: []
 *
 * Example 3:
 * Input: head = [1,2], n = 1
 * Output: [1]
 *
 * Constraints:
 * The number of nodes in the list is sz.
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 */
public class RemoveNodeFromEndList
{
    public static void main(String[] args)
    {
        ListNode head = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);
        head.next = second;
        second.next = third;
        third.next = four;
        four.next = five;
        int target = 2;
        ListNode result = removeNodeFromEndList(head, target);
        while (result != null) {
            System.out.print(result.val);
            result = result.next;
        }

    }

    private static ListNode removeNodeFromEndList(ListNode head, int target)
    {
        ListNode toReturnHead = head;
        ListNode headAux = head;
        int numNode = 0;
        int midNode;
        // Count number of nodes
        while(headAux != null ) {
            headAux = headAux.next;
            numNode++;
        }
        int toRemoveNode = numNode - target + 1;
        if(toRemoveNode == 1) {
            return head.next;
        }
        numNode = 0;
        while(head != null ) {
            numNode++;
            if(toRemoveNode - numNode == 1) {
                head.next = head.next.next;
            }
            head = head.next;
        }
        return toReturnHead;
    }

}

