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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode temp1 = list1;
        ListNode temp2 = list2;

        ListNode sentinel = new ListNode(-101);
        ListNode mover=sentinel;

        while(temp1!=null && temp2!=null){
            if(temp1.val<=temp2.val){
                ListNode add = new ListNode(temp1.val);
                mover.next=add;
                mover=add;
                temp1=temp1.next;
            }
            else{
                ListNode add2 = new ListNode(temp2.val);
                mover.next=add2;
                mover=add2;
                temp2=temp2.next;
            }
        }

        while(temp1!=null){
            ListNode nn = new ListNode(temp1.val);
            mover.next=nn;
            mover=nn;
            temp1=temp1.next;

        }

         while(temp2!=null){
            ListNode nn = new ListNode(temp2.val);
            mover.next=nn;
            mover=nn;
            temp2=temp2.next;
        }

        return sentinel.next;
        
    }
}