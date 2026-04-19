class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        if(nums[0]>0){
            return ans;
        }
        for(int i=0;i<nums.length;i++){
            if(i!=0 && nums[i]==nums[i-1]){
                continue;
            }
            int curr = nums[i];
            int target = 0-curr;
            int left = i+1;
            int right = nums.length-1;
            while(left<right){
                int sum = nums[left]+nums[right];
                if(sum==target){
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
                else if(sum>target){
                    right--;
                }
                else{
                    left++;
                }

            }


        }

        return ans;
        
    }
}
