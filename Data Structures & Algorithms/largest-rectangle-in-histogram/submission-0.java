class Solution {
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        Stack<int[]> st = new Stack<>();
        int mxarea=0;
        for(int i=0;i<len;i++){
            int start = i;// initial starting point can be extended to left
            while(!st.isEmpty() && st.peek()[1]>heights[i]){ // a decrease/fall has arrived after a monotonic increasing sequence
                int popped[] = st.pop();
                int index = popped[0];
                int height = popped[1];
                mxarea = Math.max(mxarea, height*(i-index));
                start = index;// for extending to left 
            }

            st.push(new int[]{start,heights[i]});// extending to right monotonice increase
        }

        //If any elements remain on stack to be processed/popped after whole histogram covered, keep popping and calc area

        for(int[] pair:st){
            int index = pair[0];
            int h = pair[1];
            mxarea = Math.max(mxarea,(len-index)*h);
        }

        return mxarea;

    }
}
