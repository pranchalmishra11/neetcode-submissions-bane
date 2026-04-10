class Solution {
    public int maxSubArray(int[] nums) {
        int localmax=nums[0];
        int globalmax=nums[0];

        for(int i=1;i<nums.length;i++){
            localmax = Math.max(nums[i],localmax+nums[i]);
            globalmax = Math.max(localmax,globalmax);
        }

        return globalmax;
        
    }
}
