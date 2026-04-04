class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums==null || nums.length==0){
            return 0;
        }
        Set<Integer> seen = new HashSet<>();
        for(int x:nums){
            seen.add(x);
        }

        int maxlen=1;
        for(int i=0;i<nums.length;i++){
            if(!seen.contains(nums[i]-1)){
                int len=1;
                int startval = nums[i];
                while(seen.contains(++startval)){
                    len++;
                }
                maxlen = Math.max(maxlen,len);
            }
        }

        return maxlen;

    }
}
