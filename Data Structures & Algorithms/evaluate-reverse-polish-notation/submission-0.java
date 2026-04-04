class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<Integer>();
        for(int i=0;i<tokens.length;i++){
            String token = tokens[i];
            if(token.equalsIgnoreCase("+")){
                int first = st.pop();
                int second = st.pop();
                st.push(second+first);
             }
             else if(token.equalsIgnoreCase("-")){
                int first = st.pop();
                int second = st.pop();
                st.push(second-first);
             }
             else if(token.equalsIgnoreCase("*")){
                int first = st.pop();
                int second = st.pop();
                st.push(second*first);
             }
             else if(token.equalsIgnoreCase("/")){
               int first = st.pop();
                int second = st.pop();
                st.push(second/first);
             }
             else{
                st.push(Integer.parseInt(token));
             }
        }

        return st.peek();

        
    }
}
