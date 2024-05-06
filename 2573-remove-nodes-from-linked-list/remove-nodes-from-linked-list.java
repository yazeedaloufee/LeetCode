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
 // reverse the linked list .. delete and next node that is less than the value. reverse linked list again. 


class Solution {
    public ListNode removeNodes(ListNode head) {
        ListNode reversed = reverse(head);
        ListNode curr = reversed; 
        while(curr != null ) {
            while (curr != null && curr.next != null && curr.val > curr.next.val) {
                curr.next = curr.next.next;
            }
            curr = curr.next;
        }
        return reverse(reversed);
        
    }

    public ListNode reverse(ListNode head) {
        // dont need to check for null values. 
        ListNode prev = null; 
        ListNode curr = head;

        while ( curr != null) {
            ListNode next = curr.next; 
            curr.next = prev;
            prev = curr;
            curr = next; 
        }
        return prev;
    }

}