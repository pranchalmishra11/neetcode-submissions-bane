class Solution {
    public int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length-1;
        int mx = Integer.MIN_VALUE;
        while(left<right){
            int curr = (right-left)*Math.min(heights[left],heights[right]);
            mx = Math.max(curr,mx);
            if(heights[left]<heights[right]){
                left++;
            }
            else{
                right--;
            }
        }

        return mx;

        
    }
}
