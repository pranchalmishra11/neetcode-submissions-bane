class Solution {
    Boolean cache[][];
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum=0;
        for(int x:nums){
            sum+=x;// calculate total sum
        }

        if(sum%2!=0){// if sum is odd, no chance of partion subset with equal sum
            return false;
        }

        cache = new Boolean[n][sum/2+1];// memoized cache for catching repeated problems

        return dfs(nums,0,sum/2);// recursion starts with target as half and from index 0
    }

    private boolean dfs(int nums[], int i, int target){
        if(i==nums.length){// if index reached end of nums array and target consumes to 0 then return true
            return target==0;
        }

        if(target<0){// if target went negative as we keep subtracting getting problem smaller and smaller return false
            return false;
        }

        if(null!=cache[i][target]){// check in cache if for an ith index and a target, cache already has value solved
            return cache[i][target];
        }

        cache[i][target] = dfs(nums,i+1,target) || dfs(nums,i+1,target-nums[i]);// pick and not pick case if picked subtract from target if not picked index still moves to i+1 and target remains same
        return cache[i][target];// store to cache for future and return its value
}
}
