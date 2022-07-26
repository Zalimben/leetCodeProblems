package main.java.leetCodeProblems.algorithm.common;

import java.util.List;
import java.util.Objects;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class ListNode
{
    public int val;
    public ListNode next;

    public ListNode()
    {
    }

    public ListNode(int val)
    {
        this.val = val;
    }

    public ListNode(int val, ListNode next)
    {
        this.val = val;
        this.next = next;
    }

    public ListNode(List<Integer> values)
    {
        if(values.isEmpty()) {
            return;
        }
        this.val = values.get(0);
        for(int idx = 1; idx < values.size(); idx++) {
            addNodeValue(this, values.get(idx));
        }
    }

    public ListNode(ListNode node)
    {
        this.val = node.val;
        this.next = node.next;
    }

    public void print() {
        ListNode node = this;
        while (Objects.nonNull(node)) {
            System.out.print(node.val);
            System.out.print(" ");
            node = node.next;
        }
    }

    public static ListNode init() {
        ListNode head = new ListNode(1);
        int idx = 2;
        while (idx < 6) {
            addNodeValue(head, idx);
            idx++;
        }
        return head;
    }

    public static void addNodeValue(ListNode head, int value) {
        ListNode node = new ListNode(value);
        while (Objects.nonNull(head.next)) {
            head = head.next;
        }
        head.next = node;
    }

    public static void addNode(ListNode head, ListNode node) {
        while (Objects.nonNull(head.next)) {
            head = head.next;
        }
        head.next = node;
    }

}

