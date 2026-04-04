class Solution {
    public int maxProduct(int[] nums) {
        int currmax=1;// initialize default values of mx and min
        int currmin=1;
        int result = Integer.MIN_VALUE;

        for(int i=0;i<nums.length;i++){
            int prevmax = currmax*nums[i];// precompute max value as its going to be used for currmin calculation later
            currmax = Math.max(Math.max(currmax*nums[i],currmin*nums[i]),nums[i]);// currmax processed among 3 values, multiply coming element with currmax, currmin and keeping element itself
            currmin = Math.min(Math.min(prevmax,currmin*nums[i]),nums[i]);//// currmin processed among 3 values, multiply coming element with currmax, currmin and keeping element itself
            result = Math.max(result,currmax);
        }

        return result;
        
    }
}
