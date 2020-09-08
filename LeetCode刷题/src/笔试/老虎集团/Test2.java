package 笔试.老虎集团;


import java.util.Stack;

public class Test2 {

    /**
     *
     * @param str string字符串
     * @return bool布尔型
     */
    public boolean isPalindrome (String str) {
        //利用栈实现
        Stack<Character> stack = new Stack<>();
        char[] chars = str.toCharArray();
        for (char c : chars) {
            if (('0' <= c && c <= '9') || ('A' <= c && c <= 'Z') || ('a' <= c && c <= 'z')) {
                //入栈
                stack.push(c);
            }
        }
        //来比较
        for (char c : chars) {
            if (('0' <= c && c <= '9') || ('A' <= c && c <= 'Z') || ('a' <= c && c <= 'z')) {
                //出栈比较
                char p = stack.pop();
                if(!String.valueOf(c).equalsIgnoreCase(String.valueOf(p))){
                    return false;
                }
            }
        }
        return true;
    }

}
