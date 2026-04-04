class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int x:nums){
            pq.add(x);
        }

        int ans = -1001;

        while(k!=0 && !pq.isEmpty()){
            ans = pq.poll();
            k--;
        }

        return ans;
        
    }
}
