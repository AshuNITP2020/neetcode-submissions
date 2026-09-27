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

class Solution {
    public void reorderList(ListNode head) {
        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode reverse = slow.next;
        slow.next = null;

        reverse = reversal(reverse);

        slow = head;

        while (reverse != null) {
            ListNode slowNext = slow.next;
            ListNode reverseNext = reverse.next;

            slow.next = reverse;
            reverse.next = slowNext;

            slow = slowNext;
            reverse = reverseNext;
        }
    }

    ListNode reversal(ListNode head) {
        ListNode temp = head, prev = null;

        while (temp != null) {
            ListNode next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
        }

        return prev;
    }
}
