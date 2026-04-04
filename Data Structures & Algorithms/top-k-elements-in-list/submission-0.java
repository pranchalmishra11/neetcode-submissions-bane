class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int ans[] = new int[k];
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
            }
            else{
                map.put(nums[i],1);
            }
        }

        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
            (entry1, entry2) -> Integer.compare(entry2.getValue(), entry1.getValue())
        );

        pq.addAll(map.entrySet());
        int idx=0;
        while(idx<k && !pq.isEmpty()){
            Map.Entry<Integer, Integer> entry = pq.poll();
            ans[idx++]=entry.getKey();
        }

        return ans;
    }
}
