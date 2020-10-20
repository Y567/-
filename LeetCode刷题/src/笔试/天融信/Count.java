package 笔试.天融信;

import java.util.Scanner;

public class Count {

    //统计字符串
    public static int[] getRes(String s){
        if(s.isEmpty()){
            return new int[4];
        }
        int length = s.length();
        int[] res = new int[4];
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if('0' <= c && c <= '9'){
                res[2]++;
            }else if(('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z')){
                res[0]++;
            }else if(c == ' '){
                res[1]++;
            }else{
                res[3]++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String s = in.nextLine();
            int[] res = getRes(s);
            System.out.println("英文字母: "+res[0]);
            System.out.println("空格: "+res[1]);
            System.out.println("数字: "+res[2]);
            System.out.println("其它字符: "+res[3]);
        }
    }
}
