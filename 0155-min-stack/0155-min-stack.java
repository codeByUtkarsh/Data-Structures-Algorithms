class MinStack {
    private Stack<Long> st;
    private long mini;
    public MinStack() {
        st = new Stack<>();
        mini = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        if(st.isEmpty()){
            st.push((long)val);
            mini = val;
        }else{
            if(val<mini){
                long prevMini = 2L*val-mini;
                st.push(prevMini);
                mini = val;
            }
            else{
                st.push((long)val);
            }
        }
    }
    
    public void pop() {
        if(st.isEmpty()) return;
        long val = st.peek();
        if(val<mini){
            mini = 2*mini-val;
        }
        st.pop();
    }
    
    public int top() {
        if(st.isEmpty()) return -1;
        long val = st.peek();
        return (val < mini) ? (int) mini : (int) val;
    }
    
    public int getMin() {
        return (int)mini;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */