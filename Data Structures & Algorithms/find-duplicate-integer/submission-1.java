class Solution {
    public int findDuplicate(int[] nums) {// it kind of becomes a linked list problem with use of slow and fast pointer on arrays, use of floyds start of cycle detection algorithm
    int slow=0;
    int fast=0;// first phase of algo-: to get the initial intersection point

    while(true){
        slow = nums[slow];// 1 hop
        fast = nums[nums[fast]];// 2 hops
        if(slow==fast){
            break;
        }
    }

    int slow2=0;// start of 2nd phase slow2 starts from start of list
    while(true){
        slow = nums[slow];// slow also moves from where it stopped in 1st pass
        slow2 = nums[slow2];
        if(slow==slow2){
            return slow;
        }
    }

    }
}
