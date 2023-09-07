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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;

        ListNode prev = dummyNode;
        ListNode curr =head;

       
        for(int i=0;i<left-1;i++){
            prev = prev.next;
            curr = curr.next;
        }

        ListNode subListHead = curr;
        ListNode nPrev = null;
        for(int i=0;i<right-left+1;i++){
            ListNode next = curr.next;
            curr.next = nPrev;
            nPrev = curr;
            curr = next;
        }

        prev.next = nPrev;
        subListHead.next = curr;

        return dummyNode.next;
    }
}