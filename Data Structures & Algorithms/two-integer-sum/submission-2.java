class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        int ans[] = new int[2];
        for(int i=0;i<nums.length;i++){
           map.put(nums[i],i);
        }

        for(int i=0;i<nums.length;i++){
            int find = target-nums[i];
            if(map.containsKey(find) && map.get(find)!=i){
                ans[0]=i;
                ans[1]=map.get(find);
                break;
            }
        }


        return ans;


        
    }
}
