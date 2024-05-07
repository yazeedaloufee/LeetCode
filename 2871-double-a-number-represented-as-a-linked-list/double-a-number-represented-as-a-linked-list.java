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
        ListNode curr = reverse(head);
        int carry = 0; 
        ListNode tempFirst = curr;
        ListNode temp = curr;
        
        while ( curr != null) {
            int number = curr.val * 2 + carry;
            curr.val = number % 10;
            carry = number / 10;
            temp = curr;
            curr = curr.next;
        }
        if (carry != 0) {
            ListNode newNode = new ListNode(carry);
            temp.next = newNode;
            temp = temp.next;
        }
        return reverse(tempFirst);
        
    }

    public ListNode reverse (ListNode head) {
        if (head == null) return null;
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }


}
