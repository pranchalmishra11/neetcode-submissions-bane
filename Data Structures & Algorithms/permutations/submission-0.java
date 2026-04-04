class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        int n = nums.length;
        boolean pick[] = new boolean[n];
        calldfs(ds,pick,ans,nums);
        return ans;
    }

    private void calldfs(List<Integer> ds, boolean pick[],List<List<Integer>> ans,int nums[]){
        if(ds.size()==nums.length){
            ans.add(new ArrayList<>(ds));
            return;
        }

        for(int i=0;i<nums.length;i++){
            if(pick[i]==false){
                ds.add(nums[i]);
                pick[i]=true;
                calldfs(ds,pick,ans,nums);
                ds.remove(ds.size()-1);
                pick[i]=false;
            }
        }
    }
}
