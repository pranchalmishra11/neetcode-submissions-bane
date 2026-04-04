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
    public void reorderList(ListNode head) {
        ListNode slow = head;// detect half of the list using slow and fast pointer technique
        ListNode fast = head.next;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode second = slow.next;// second half of the list
        ListNode prev = slow.next = null;

        while(second!=null){// reversing the 2nd half of the list for the merge
            ListNode tmp = second.next;
            second.next = prev;
            prev = second;
            second = tmp;
        }

        ListNode firsthalf = head;// merging the 2 halves now
        ListNode secondhalf = prev;
        
        while(secondhalf!=null){
            ListNode tmp1 = firsthalf.next;
            ListNode tmp2 = secondhalf.next;
            firsthalf.next = secondhalf;
            secondhalf.next = tmp1;
            firsthalf=tmp1;
            secondhalf=tmp2;
        } 
    }
}
