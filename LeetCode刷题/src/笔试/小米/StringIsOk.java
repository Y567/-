package 笔试.小米;

import java.util.Scanner;
import java.util.Stack;

public class StringIsOk {

    /**
     * 思路：用栈实现，遍历到}就看{
     * @param s  需要判断字符串
     * @return   返回true
     */
    public static boolean isOk(String s){
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c){
                case '{':
                    stack.push('{');
                    break;
                case '(':
                    stack.push('(');
                    break;
                case '[':
                    stack.push('[');
                    break;
                case '}':
                    if(stack.isEmpty() || !stack.peek().equals('{')){
                        return false;
                    }else{
                        stack.pop();
                    }
                    break;
                case ']':
                    if(stack.isEmpty() || !stack.peek().equals('[')){
                        return false;
                    }else{
                        stack.pop();
                    }
                    break;
                case ')':
                    if(stack.isEmpty() || !stack.peek().equals('(')){
                        return false;
                    }else{
                        stack.pop();
                    }
                    break;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String line = in.nextLine();
            System.out.println(isOk(line));
        }
    }
}
