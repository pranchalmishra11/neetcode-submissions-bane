class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for(int x:nums){
            set.add(x);
        }

        return set.size()<nums.length;

    }
}