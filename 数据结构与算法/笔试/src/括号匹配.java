import java.util.Stack;

public class 括号匹配 {

    /**
     *
     * @param s string字符串
     * @return bool布尔型
     * 思路：使用一个栈去判断，最后栈为空就是满足左右闭合
     */
    public boolean IsValidExp (String s) {
        if(s.isEmpty()){
            //为空是有效的字符串
            return true;
        }
        Stack<Character> stack = new Stack<Character>();
        char[] chars = s.toCharArray();
        for(char c:chars){
            switch (c){
                case '{':
                    stack.push(c);
                    break;
                case '[':
                    stack.push(c);
                    break;
                case '(':
                    stack.push(c);
                    break;
                case '}':
                    if(stack.isEmpty()){
                        return false;
                    }else if(stack.peek()=='{'){
                        stack.pop();
                    }else{
                        return false;
                    }
                    break;
                case ']':
                    if(stack.isEmpty()){
                        return false;
                    }else if(stack.peek()=='['){
                        stack.pop();
                    }else{
                        return false;
                    }
                    break;
                case ')':
                    if(stack.isEmpty()){
                        return false;
                    }else if(stack.peek()=='('){
                        stack.pop();
                    }else{
                        return false;
                    }
                    break;
            }
        }
        return stack.isEmpty();
    }
}
