package 笔试.哔哩哔哩;

import java.util.Scanner;
import java.util.Stack;

public class 菱形 {

    //生成一行字符串
    public static String getLine(int n,int m){
        //第几行
        StringBuilder s = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            s.append(i);
        }
        for (int i = n-1; i > 0 ; i--) {
            s.append(i);
        }

        for (int i = 0; i < m-s.length()/2; i++) {
            s.insert(0,"*");
            s.append("*");
        }
        return s.toString();
    }

    public static String getL(int n){
        if(n % 2 == 0){
            //偶数则无法输出
            return "";
        }
        StringBuilder result = new StringBuilder();
        //利用栈来记录对称的情况
        Stack<String> stack = new Stack<>();
        //前几排的东西
        for (int i = 1; i <= n/2; i++) {
            String line = getLine(i,n);
            result.append(line).append("|");
            stack.push(line);
        }
        //中间行
        result.append(getLine(n/2+1,n)).append("|");

        while(!stack.isEmpty()){
            result.append(stack.pop());
            if(!stack.isEmpty()){
                result.append("|");
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int n = in.nextInt();
            System.out.println(getL(n));
        }
    }
}
