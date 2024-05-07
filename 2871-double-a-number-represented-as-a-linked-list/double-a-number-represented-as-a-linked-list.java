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
    public ListNode doubleIt(ListNode head) {
        if ( head == null) {
            return head;
        }
        
        int carry = helper(head);

        if (carry != 0) {
            ListNode c = new ListNode(carry);
            c.next = head;
            return c;
        }
        return head;
        
    }
    public int helper(ListNode head) {
        if(head == null) return 0; 
        int prev = helper(head.next);

        prev = head.val * 2 + prev;

        head.val = prev % 10;
        return prev / 10;
    }
}