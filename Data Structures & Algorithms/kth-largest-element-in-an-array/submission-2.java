class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        for(int x:nums){
            pq.add(x);
        }

        int count=0;
        int ans=-1;
        while(!pq.isEmpty() && count!=k){
            ans = pq.poll();
            count++;
        }

        return ans;

        
    }
}
