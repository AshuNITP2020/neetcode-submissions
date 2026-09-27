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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
       if (list1 != null && list2 != null && list2.val < list2.val) {
        return mergeTwoLists(list2, list1);
       }
        
       ListNode dummy  = new ListNode(), result = dummy;

       while(list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                dummy.next = list1;
                dummy = list1;
                list1 = list1.next;
            } else if (list1.val > list2.val) {
                dummy.next = list2;
                dummy = list2;
                list2 = list2.next;
            } else {
                dummy.next = list1;
                dummy = list1;
                list1 = list1.next;
                dummy.next = list2;
                dummy = list2;
                list2 = list2.next;
            }
       }

       while(list1 != null) {
            dummy.next = list1;
            dummy = list1;
            list1 = list1.next;
       }

       while(list2 != null) {
            dummy.next = list2;
            dummy = list2;
            list2 = list2.next;
       }

       return result.next;
    }
}
