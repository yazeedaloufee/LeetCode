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
    public ListNode removeNodes(ListNode head) {
        if(head == null) return head; 
        ListNode rec = removeNodes(head.next);

        if(rec != null && rec.val > head.val) {
            head  = rec;
        }else {
            head.next = rec;
        }
        return head;
        
    }
}