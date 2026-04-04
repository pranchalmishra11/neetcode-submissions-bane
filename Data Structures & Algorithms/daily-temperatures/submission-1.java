class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int ans[] = new int[n];
        Stack<int[]> st = new Stack<>();
        for(int i=0;i<n;i++){
            int currtemp = temperatures[i];
            while(!st.isEmpty() && currtemp>st.peek()[0]){
                int popped[] = st.pop();
                int index = popped[1];
                ans[index] = i-index;
            }

            st.push(new int[]{currtemp,i});
        }

        return ans;
    }
}
