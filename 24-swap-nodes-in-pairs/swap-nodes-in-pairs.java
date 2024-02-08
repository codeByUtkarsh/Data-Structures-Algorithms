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
    public ListNode swapPairs(ListNode head) {
        ListNode temp = head;
        int size=0;
        while(temp!=null){
            size++;
            temp = temp.next;
        }
        if(size%2==0){
            temp = head;
            int tem = 0;
            for(int i=0;i<size;i=i+2){
                tem = temp.val;
                temp.val = temp.next.val;
                temp.next.val = tem;
                temp = temp.next.next;
            }
        }else{
            temp = head;
            int tem = 0;
            for(int i=0;i<size-1;i=i+2){
                tem = temp.val;
                temp.val = temp.next.val;
                temp.next.val = tem;
                temp = temp.next.next;
            }
        }
        return head;
    }
}