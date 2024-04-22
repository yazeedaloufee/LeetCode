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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode start = new ListNode();
        ListNode curr = start;
        while (true) {
            int index = findLeastIndex(lists);
            if(index == -1) break;
            curr.next = lists[index];
            lists[index] = lists[index].next;
            curr = curr.next;

        }
        return start.next;
    }
    private int findLeastIndex (ListNode[] list) {
        int min = Integer.MAX_VALUE;
        int index = -1;
        for (int i = 0; i < list.length; i++) {
            if(list[i] != null && list[i].val < min) {
                index = i;
                min = list[i].val;
            }
        }
        return index;
    }
}