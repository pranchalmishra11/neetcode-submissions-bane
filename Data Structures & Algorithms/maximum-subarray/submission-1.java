class Solution {
    public int maxSubArray(int[] nums) {
        if(nums.length==0 || nums==null){
            return 0;
        }

        int n = nums.length;
        if(n==1){
            return nums[0];
        }
        int localmax=nums[0];
        int globalmax=nums[0];

        for(int i=1;i<n;i++){
            localmax = Math.max(localmax+nums[i],nums[i]);
            globalmax = Math.max(globalmax,localmax);
        }

        return globalmax;
        
    }
}
