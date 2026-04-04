class MinStack {
    Stack<Integer> st;
    Stack<Integer> minStack;


    public MinStack() {
        st = new Stack<>();
        minStack = new Stack<>();
        
    }
    
    public void push(int val) {
        st.push(val);
        if(minStack.isEmpty()){
            minStack.push(val);
        }
        else if(!minStack.isEmpty() && minStack.peek()>=val){
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
        return !st.isEmpty()?st.peek():-1; 
        
    }
    
    public int getMin() {
        return !minStack.isEmpty()?minStack.peek():-1;
        
    }
}
