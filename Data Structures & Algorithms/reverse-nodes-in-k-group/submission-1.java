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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null || k==1){
            return head;
        }
        ListNode temp = head;
        ListNode prevNode=null;
        while(temp!=null){
            ListNode kthNode = findKthNode(temp,k);// get the kthNode
            if(kthNode==null){// no k group further, connect prevNode as it is to further linkedList(no reversal required)
                if(prevNode!=null){
                    prevNode.next=temp;
                }
                break;
            }
            ListNode nextNode = kthNode.next;// preserve next part of linked list after thi kth group
            kthNode.next=null; // make last node's next to null of the kth group to send this group list for reversal
            reverseKGroupList(temp);
            if(temp==head){// if first k group then head can be reassigned 
                head=kthNode;
            }
            else{// if other k group then connect prevNode to new upcoming k group
                prevNode.next = kthNode;
            }

            prevNode=temp;// move nodes for next iteration
            temp=nextNode;
        }

        return head;
    }

    private ListNode findKthNode(ListNode temp, int k){
        k=k-1;
        while(temp!=null && k>0){
            temp = temp.next;
            k--;
        }

        return temp;
    }

    private void reverseKGroupList(ListNode temp){
        ListNode prev = null;
        ListNode curr = temp;
        while(curr!=null){
            ListNode after = curr.next;
            curr.next=prev;
            prev=curr;
            curr=after;
        }


    }
}
