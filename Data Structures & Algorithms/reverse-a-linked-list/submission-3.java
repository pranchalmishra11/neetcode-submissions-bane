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
    public ListNode reverseList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode curr=head;
        ListNode after=head;
        ListNode prev=null;

        while(curr.next!=null){
            after=curr.next;
            curr.next=prev;
            prev=curr;
            curr=after;
        }

        curr.next=prev;
        prev=curr;
        
        return prev;

        
    }
}
