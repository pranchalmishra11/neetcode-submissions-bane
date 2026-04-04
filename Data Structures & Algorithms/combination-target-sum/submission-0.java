class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp  = new ArrayList<>();
        int n = nums.length;
        findcombinations(0,nums,target,temp,ans,n);
        return ans;
    }

    private void findcombinations(int index, int nums[], int target, List<Integer> temp, List<List<Integer>> ans, int len){
        if(index==len){
            if(target==0){
                ans.add(new ArrayList<>(temp));
            }
            return;
        }

        if(nums[index]<=target){
            temp.add(nums[index]);
            findcombinations(index,nums,target-nums[index],temp,ans,len);// pick element
            temp.remove(temp.size()-1);// backtrack
        }

        findcombinations(index+1,nums,target,temp,ans,len);// not pick element

    }
}
