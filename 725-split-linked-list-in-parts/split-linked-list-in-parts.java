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
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] ans = new ListNode[k];
        ListNode curr = head;
        int n=0;
        while(curr!=null){
            n++;
            curr = curr.next;
        }
        int eachSize = n/k;
        int extraNode = n%k;
        curr = head;
        ListNode prev = null;

        for(int i=0;i<k && curr!=null ;i++,extraNode--){

            ans[i]=curr;

            for(int j=0;j< eachSize +(extraNode>0 ? 1:0);j++){
                prev = curr;
                curr = curr.next;
            }

            if(prev != null){
                prev.next = null;
            }
        }
        return ans;
    }
}