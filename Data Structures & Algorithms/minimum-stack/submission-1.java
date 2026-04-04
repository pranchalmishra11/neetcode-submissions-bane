class MinStack {// solving for O(1) time for each function---use of 2 stacks
    Stack<Integer> st;
    Stack<Integer> minStack;

    public MinStack() {
        minStack = new Stack<>();
        st = new Stack<>();
    }
    
    public void push(int val) {
        st.push(val);
        if(minStack.isEmpty() || val<=minStack.peek()){
            minStack.push(val);
        }

        
    }
    
    public void pop() {
        int popped = st.pop();
        if(!minStack.isEmpty() && popped==minStack.peek()){
            minStack.pop();
        }

        
    }
    
    public int top() {
        if(!st.isEmpty()){
            return st.peek();
        }

        return -1;
        
    }
    
    public int getMin() {
        if(!minStack.isEmpty()){
            return minStack.peek();
        }

        return -1;
        
    }
}
