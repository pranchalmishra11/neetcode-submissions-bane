class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = candidates.length;
        Arrays.sort(candidates);// sorting helps for the dupliacy avoidance
        List<Integer> temp = new ArrayList<>();
        findCombinations(0,candidates,target,temp,ans,0);
        return ans;
    }

    private void findCombinations(int index, int nums[], int target, List<Integer> temp, List<List<Integer>> ans, int total){
        if(target==total){
            ans.add(new ArrayList<>(temp));
            return;
        }

        if(total>target || index==nums.length){
            return;
        }
        temp.add(nums[index]);
        findCombinations(index+1,nums,target,temp,ans,total+nums[index]);//picking case
        temp.remove(temp.size()-1);
        while(index+1<nums.length && nums[index]==nums[index+1]){// avoiding duplicacy when skipping/notpicking
            index++;
        }

        findCombinations(index+1,nums,target,temp,ans,total);

    }
}
