class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        StringBuilder st = new StringBuilder();
        backtrack(st,result,0,0,n);
        return result;       
    }

    private void backtrack(StringBuilder st, List<String> result,int open, int closed, int n){
            if(open==closed && open==n && closed==n){//base case
                result.add(st.toString());
            }

            if(open<n){
                st.append("(");
                backtrack(st,result,open+1,closed,n);
                st.deleteCharAt(st.length()-1);// backtrack to previous stage so another path can be tried
            }

            if(open>closed){
                st.append(")");
                backtrack(st,result,open,closed+1,n);
                st.deleteCharAt(st.length()-1);// // backtrack to previous stage so another path can be tried
            }
    }
}

