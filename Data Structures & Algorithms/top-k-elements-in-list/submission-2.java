class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        int ans[] = new int[k];
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
            }
            else{
                map.put(nums[i],1);
            }
        }

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a,b)->(map.get(b)-map.get(a)));
        pq.addAll(map.keySet());

        int index=0;

        while(!pq.isEmpty() && index!=k){
            ans[index++] = pq.poll();
        }

        return ans;

    }
}
