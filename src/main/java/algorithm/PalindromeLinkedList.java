package main.java.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import main.java.algorithm.common.ListNode;

/**
 * 234. Palindrome Linked List
 * <p>
 * Given the head of a singly linked list, return true if it is a palindrome.
 * <p>
 * Example 1:
 * Input: head = [1,2,2,1]
 * Output: true
 * <p>
 * Example 2:
 * Input: head = [1,2]
 * Output: false
 * <p>
 * Constraints:
 * The number of nodes in the list is in the range [1, 10⁵].
 * 0 <= Node.val <= 9
 */
public class PalindromeLinkedList
{

    public static void main(String[] args)
    {
        ListNode head = new ListNode(1);
        String palindrome = "12345678987654321";

        char[] palindromeChar = palindrome.toCharArray();
        for(int idx = 1; idx < palindromeChar.length; idx++) {
            ListNode.addNodeValue(head, Integer.parseInt(String.valueOf(palindromeChar[idx])));
        }
        boolean isPal = isPalindrome(head);
        System.out.println(isPal);
    }

    public static boolean isPalindrome(ListNode head) {
        List<Integer> numbers = new ArrayList<>();
        while(Objects.nonNull(head)) {
            numbers.add(head.val);
            head = head.next;
        }
        int init = 0;
        int tail = numbers.size() -1;
        while(init < tail) {
            if(!Objects.equals(numbers.get(init), numbers.get(tail))) {
                return false;
            }
            init++;
            tail--;
        }
        return true;
    }
}
