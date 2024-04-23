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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null) return head;

        ListNode curr = head;
        ListNode[] result = new ListNode[2];

        // check if k list has k or more nodes. 
        if(checked(curr, k)){
            result = reverse(curr, k);
            curr.next = reverseKGroup(result[1], k);
            return result[0];
        } else {
            return head;
        }

    }
    private ListNode[] reverse(ListNode node, int k) {
        ListNode curr = node; 
        ListNode prev = null;
        int counter = 0;

        while(counter < k){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            counter++;
        }

        return new ListNode[]{prev, curr};
    }



    private boolean checked (ListNode head,int k) {
        if( head == null) return false;
        ListNode curr = head;
        int counter = 1; 
        while(curr.next != null) {
            curr = curr.next;
            counter++;
            if(counter >= k ) return true;
        }
        return counter >= k;
    }
}