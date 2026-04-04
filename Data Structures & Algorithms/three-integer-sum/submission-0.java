class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> anslist = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0)
                break;    // array is sorted if first is +ve no chance to get a sum==0
            if(i>0 && nums[i]==nums[i-1]){
                continue; // avoid duplicacy for the 1st pick of the three
            }

            int left = i+1;
            int right = nums.length-1;
            while(left<right){
                int sum = nums[i]+nums[left]+nums[right];
                if(sum>0){
                    right--;
                }
                else if(sum<0){
                    left++;
                }
                else{
                    anslist.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    left++;
                    right--;
                    while(left<right && nums[left]==nums[left-1]){// avoiding duplicacy for inner 2 pointer loop(sorted), till left index keeps getting same num, we keep moving
                        left++;
                    }
                }
            }
        }

        return anslist;
    }
}
