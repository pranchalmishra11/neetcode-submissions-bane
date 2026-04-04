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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum=0;
        ListNode curr = l1;
        int p=0;
        while(curr!=null){
            sum = sum+(curr.val*(int)(Math.pow(10,p++)));
            curr = curr.next;
        }

       curr=l2;
       p=0;
       while(curr!=null){
        sum = sum+(curr.val*(int)(Math.pow(10,p++)));
            curr = curr.next;
       }
        ListNode dummy = new ListNode();
        ListNode mover = dummy;
        if(sum==0){
            ListNode ans = new ListNode(0,null);
            return ans;
        }
       
        while(sum!=0){
            int d = sum %10;
            ListNode n = new ListNode(d);
            mover.next=n;
            mover=n;
            sum = sum/10;
        }

        return dummy.next;

    }
}
