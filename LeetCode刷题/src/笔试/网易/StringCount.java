package 笔试.网易;

import java.util.Scanner;

public class StringCount {

    public static boolean isOk(String s){
        //查看该字符串是否满足规则
        int one = 0,two = 0,three = 0,four = 0,five = 0,six = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == 'a'){
                one++;
            }else if(c == 'b'){
                two++;
            }else if(c == 'c'){
                three++;
            }else if(c == 'x'){
                four++;
            }else if(c == 'y'){
                five++;
            }else if(c == 'z'){
                six++;
            }
        }
        //统计完毕，当6个变量都是偶数的时候则说明满足条件，如果没有遇到a,b,c,x,y,z那么变量也是0是偶数
        return ((one & 1) == 0) && ((two & 1) == 0) && ((three & 1) == 0) && ((four & 1) == 0) && ((five & 1) == 0) && ((six & 1) == 0);
    }

    //求所有字串的方法
    public static int getMaxSize(String s){
        if(s.isEmpty()){
            return 0;
        }
        int maxSize = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                String sub = s.substring(i,j+1);
                if(isOk(sub) && sub.length() > maxSize){
                    maxSize = sub.length();
                }
            }
        }
        return maxSize;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String line = in.nextLine();
            System.out.println(getMaxSize(line));
        }
    }
}
