class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        for(int x:nums){
            seen.add(x);
        }

        int mx=0;
        for(int i=0;i<nums.length;i++){
            int curr = nums[i]-1;
            if(!seen.contains(curr)){
                int n = nums[i];
                int count=0;
                while(seen.contains(n)){
                    n++;
                    count++;
                }

                mx = Math.max(mx,count);
            }
        }

        return mx;

        
    }
}
