import java.util.Stack;

class MinStack {

    private Stack<Integer> data = new Stack<>();
    private Stack<Integer> min = new Stack<>();
    /** initialize your data structure here. */
    public MinStack() {

    }

    public void push(int x) {
        data.push(x);
        if(min.empty()){
            min.push(x);
            return;
        }
        if(x <= min.peek()){
            min.push(x);
        }else{
            min.push(min.peek());
        }
    }

    public void pop() {
        if(!data.empty() && !min.empty()){
            data.pop();
            min.pop();
        }
    }

    public int top() {
        return data.peek();
    }

    public int min() {
        return min.peek();
    }
}

public class 包含最小min函数的栈 {
}
