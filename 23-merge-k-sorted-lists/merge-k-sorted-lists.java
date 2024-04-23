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
        if(lists == null || lists.length == 0){
            return null;
        }
        List<ListNode> temp = new ArrayList<>();
        List<ListNode> temp2 = new ArrayList<>();

        for(ListNode node : lists) {
            temp.add(node);
        }


        while(temp.size() > 1) {
            while(temp.size() > 0) {
                ListNode node1 = temp.remove(0);
                ListNode node2 = temp.size() < 1 ? null: temp.remove(0);
                ListNode result = mergeTwo(node1, node2);
                temp2.add(result);
            }
            temp = temp2;
            temp2 = new ArrayList<ListNode>();
            
        }
        return temp.get(0);
    }

    private ListNode mergeTwo(ListNode node1, ListNode node2){
        ListNode dummy = new ListNode();
        ListNode curr = dummy;

        while(node1 != null && node2 != null) {
            if(node1.val < node2.val) {
                curr.next = node1;
                node1 = node1.next;
            } else {
                curr.next = node2;
                node2 = node2.next;
            }
            curr = curr.next;
        }
        curr.next = node2 == null? node1 : node2;

        return dummy.next;
        
    }
}