class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int target = 0;
        if(nums[0]>0){
            return ans;
        }
        for(int i=0;i<nums.length;i++){
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }
            int newTarget = target-nums[i];
            int left = i+1;
            int right = nums.length-1;
            while(left<right){
                int currsum = nums[left]+nums[right];
                if(currsum==newTarget){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[left]);
                    temp.add(nums[right]);
                    ans.add(temp);
                    left++;
                    right--;
                    while(left<right && nums[left]==nums[left-1]){
                        left++;
                    }
                }
                else if(currsum<newTarget){
                    left++;
                }
                else{
                    right--;
                }
            }
        }

        return ans;


        
    }
}
