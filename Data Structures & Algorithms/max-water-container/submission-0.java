class Solution {
    public int maxArea(int[] heights) {
        int mx_area = Integer.MIN_VALUE;
        int left=0;
        int right = heights.length-1;
        while(left<right){
            mx_area = Math.max(mx_area,(right-left)*Math.min(heights[left],heights[right]));
            if(heights[left]<heights[right]){
                left++;
            }
            else{
                right--;
            }
        }

        return mx_area;
    }
}
