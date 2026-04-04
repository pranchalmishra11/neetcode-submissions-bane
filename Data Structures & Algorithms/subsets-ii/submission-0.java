class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(0,ans,temp,nums);
        return ans;
    }


    private void backtrack(int i,List<List<Integer>> ans,List<Integer> temp,int nums[]){
        if(i==nums.length){
            ans.add(new ArrayList<>(temp));
            return;
        }
        temp.add(nums[i]);
        backtrack(i+1,ans,temp,nums);
        temp.remove(temp.size()-1);
        
        while(i+1<nums.length && nums[i]==nums[i+1]){
            i++;
        }

        backtrack(i+1,ans,temp,nums);

    }
}
