import java.util.LinkedList;
import java.util.Queue;

public class 队列实现栈 {

    class MyStack {

        private Queue<Integer> queue = new LinkedList<>();

        /** Initialize your data structure here. */
        public MyStack() {
        }

        /** Push element x onto stack. */
        public void push(int x) {
            //正常的添加进去就好
            queue.add(x);
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            //搞事情，需要出栈的时候，将队列中前面的全删除添加进去
            for (int i = 0; i < queue.size() - 1; i++) {
                //remove的是列表首节点
                queue.add(queue.remove());
            }
            return queue.remove();
        }

        /** Get the top element. */
        public int top() {
            for (int i = 0; i < queue.size() - 1; i++) {
                //remove的是列表首节点
                queue.add(queue.remove());
            }
            int result = queue.remove();
            queue.add(result);
            return result;
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return queue.size() == 0;
        }
    }
}
