import java.util.Stack;

public class 验证栈的合法顺序 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int j = 0;
        for (int i1 : pushed) {
            //直接遍历入栈
            stack.push(i1);
            while (!stack.empty() && stack.peek() == popped[j]) {
                //与栈顶元素相等，即可出栈
                stack.pop();
                j++;//相当于出栈了;
            }
        }
        //最后看栈是否为空
        return stack.empty();
    }
}
