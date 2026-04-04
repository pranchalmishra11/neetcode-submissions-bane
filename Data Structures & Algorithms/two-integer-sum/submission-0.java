class Solution {
    public int[] twoSum(int[] nums, int target) {
        int ans[] = new int[2];
        Map<Integer,Integer> map  = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],i);
        }

        for(int i=0;i<nums.length;i++){
            int et = target-nums[i];
            if(map.containsKey(et) && map.get(et)!=i){
                int x = map.get(et);
                if(i<x){
                    ans[0]=i;
                    ans[1]=x;
                }
                else{
                    ans[0]=x;
                    ans[1]=i;
                }
            }
        }

        return ans;
        
    }
}
