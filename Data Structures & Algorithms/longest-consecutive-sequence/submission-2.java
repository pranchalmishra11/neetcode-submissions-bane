class Solution {
    public int longestConsecutive(int[] nums) {
       Set<Integer> set = new HashSet<>();
       for(int p:nums){
         set.add(p);
       } 

        int mxlen = 0;
       for(int i=0;i<nums.length;i++){
            int currval = nums[i]-1;
            if(set.contains(currval)==false){
                int len=0;
                while(set.contains(nums[i]++)){
                    len++;
                }
                mxlen = Math.max(len,mxlen);
            }
       }

       return mxlen;
    }
}
