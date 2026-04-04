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
        if(list1==null  && list2!=null){
            return list2;
        }

        if(list1!=null && list2==null){
            return list1;
        }

        ListNode head1 = list1;
        ListNode head2 = list2;
        ListNode ans = new ListNode(-101);
        ListNode mover = ans;
        while(head1!=null && head2!=null){
            ListNode node1 = new ListNode(head1.val);
            ListNode node2 = new ListNode(head2.val);
            if(head1.val<=head2.val){
                mover.next = node1;
                mover=node1;
                head1 = head1.next;
            }
            else{
                 mover.next=node2;
                 mover=node2;
                 head2 = head2.next;
            }
        }

        while(head1!=null){
            ListNode node1 = new ListNode(head1.val);
            mover.next = node1;
            mover=node1;
            head1 = head1.next;

        }

        while(head2!=null){
            ListNode node2 = new ListNode(head2.val);
            mover.next=node2;
            mover=node2;
            head2 = head2.next;
        }

        return ans.next;

    }
}