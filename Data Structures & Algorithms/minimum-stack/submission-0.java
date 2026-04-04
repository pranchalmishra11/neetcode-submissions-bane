class MinStack {
    Stack<Integer> st;

    public MinStack() {
        st = new Stack<Integer>();
    }
    
    public void push(int val) {
        st.push(val);
    }
    
    public void pop() {
        if(!st.isEmpty()){
            st.pop();
        }
        
    }
    
    public int top() {
        if(!st.isEmpty()){
            return st.peek();
        }
        return -1;
    }
    
    public int getMin() {
        Stack<Integer> tempstack = new Stack<>();
        int min = st.peek();
        while(!st.isEmpty()){
            min = Math.min(min,st.peek());
            tempstack.push(st.pop());
        }

        while(!tempstack.isEmpty()){
            st.push(tempstack.pop());
        }

        return min;
        
    }
}
