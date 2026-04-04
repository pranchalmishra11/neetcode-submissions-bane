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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len=0;
        ListNode tmp = head;
        while(tmp!=null){
            tmp = tmp.next;
            len++;
        }

        int delstart = len-n+1;
        if(delstart==1){
            head = head.next;
            return head;
        }
        else{
            int reach = delstart-1;
            int count=1;
            tmp = head;
            while(count!=reach && tmp!=null){
                tmp = tmp.next;
                count++;
            }

            tmp.next = tmp.next.next;
            return head;
        }

    }
}
