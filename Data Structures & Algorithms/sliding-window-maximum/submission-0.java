class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> anslist = new ArrayList<Integer>();
        int n = nums.length;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        for(int i=0;i<k;i++){
            pq.add(nums[i]);
        }
        int lw=0;
        int rw = k-1;
        while(rw<n){
            int currmax = pq.peek();
            anslist.add(currmax);
            pq.remove(nums[lw]);
            lw++;
            ++rw;
            if(rw<n){
                pq.add(nums[rw]);
            }
        }

        int ans[] = new int[anslist.size()];
        for(int i=0;i<anslist.size();i++){
            ans[i] = anslist.get(i);
        }

        return ans;

    }
}
