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

        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        pq.addAll(map.entrySet());

        int index=0;
        while(!pq.isEmpty() && index!=k){
            Map.Entry<Integer,Integer> entry = pq.poll();
            ans[index++]=entry.getKey();
        }

        return ans;

        
    }
}
