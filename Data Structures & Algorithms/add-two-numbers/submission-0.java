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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp = new ListNode();
        ListNode result = temp;
        int carry = 0;

        while(l1 != null && l2 != null) {
            int num1 = l1.val;
            int num2 = l2.val;

            int sum = num1 + num2 + carry;

            carry = sum / 10;
            sum = sum%10;

            ListNode ln = new ListNode(sum);
            temp.next = ln;
            temp = ln;

            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            int sum = l1.val + carry;
            carry = sum / 10;
            sum = sum%10;

            ListNode ln = new ListNode(sum);
            temp.next = ln;
            temp = ln;

            l1 = l1.next;
        }

        while (l2 != null) {
            int sum = l2.val + carry;
            carry = sum / 10;
            sum = sum%10;

            temp.next = new ListNode(sum);;
            temp = temp.next;
            
            l2 = l2.next;
        }

        if (carry > 0) {
            temp.next = new ListNode(carry);
        }

        return result.next;
    }

    public ListNode reverseList(ListNode head) {

        ListNode previousNode = null;
        ListNode currentNode = head;

        while (currentNode != null) {

            ListNode nextNode = currentNode.next;

            currentNode.next = previousNode;

            previousNode = currentNode;
            currentNode = nextNode;
        }

        return previousNode;
    }
}
