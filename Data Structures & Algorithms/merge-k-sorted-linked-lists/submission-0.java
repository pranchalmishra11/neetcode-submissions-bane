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
        if(null==lists || lists.length==0){
            return null;
        }

        ListNode result = lists[0];
        for(int i=1;i<lists.length;i++){
            result = merge(result,lists[i]);
        }

        return result;

    }

    private ListNode merge(ListNode result, ListNode curr){
        ListNode dummy = new ListNode();
        ListNode tmp1 = result;
        ListNode tmp2 = curr;
        ListNode mover = dummy;
        while(tmp1!=null && tmp2!=null){
            if(tmp1.val<=tmp2.val){
                ListNode node = new ListNode(tmp1.val);
                mover.next = node;
                mover=node;
                tmp1 = tmp1.next;
            }
            else{
                ListNode node = new ListNode(tmp2.val);
                mover.next = node;
                mover=node;
                tmp2 = tmp2.next;
            }
        }

        while(tmp1!=null){
             ListNode node = new ListNode(tmp1.val);
                mover.next = node;
                mover=node;
              tmp1=tmp1.next;
        }

        while(tmp2!=null){
             ListNode node = new ListNode(tmp2.val);
                mover.next = node;
                mover=node;
              tmp2=tmp2.next;
        }

        return dummy.next;

    }
}
