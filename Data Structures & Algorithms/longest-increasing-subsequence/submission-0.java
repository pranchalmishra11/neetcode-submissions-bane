class Solution {
    public int lengthOfLIS(int[] nums) {
        int dp[] = new int[nums.length];
        Arrays.fill(dp,1);// fill all initial values with 1 as if the element itself is only chosen for its subsequence so length 1
        for(int i=nums.length-1;i>=0;i--){// moving backwars from end of array
            for(int j=i+1;j<nums.length;j++){// and checking all the elements after that using j if they are strictly greater than ith element so they can be part of increasing susbequence
                if(nums[i]<nums[j]){// if increasing then choose between itlself length 1 and all LIS's created after that while moving backwards and add 1
                    dp[i] = Math.max(dp[i],1+dp[j]);
                }
            }
        }

        int max=dp[0];
        for(int i=1;i<dp.length;i++){
            max = Math.max(max,dp[i]);// get the max out of all lengths LIS, doesnt necessrily means dp[0] will give that
        }

        return max;
        
    }
}
