package 笔试.ThreeSixZero;

import java.util.ArrayList;
import java.util.Scanner;

public class 密码复杂性 {


    public static String isOk(String s){
        if(s == null || s.length() < 8){
            return "Irregular password";
        }
        int a = 0;
        int b = 0;
        int c = 0;
        int d = 0;
        for (int i = 0; i < s.length(); i++) {
            char cc = s.charAt(i);
            if('0' <= cc && cc <= '9'){
                //数字
                a = 1;
            }else if('A' <= cc && cc <= 'Z'){
                b = 1;
            }else if('a' <= cc && cc <= 'z'){
                c = 1;
            }else{
                //其他符号
                d = 1;
            }
        }
        if((a & b & c & d) == 1){
            return "OK";
        }else{
            return "Irregular password";
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<String>();
        while(in.hasNext()){
            String s = in.nextLine();
            list.add(isOk(s));
        }
        for (String s : list) {
            System.out.println(s);
        }
    }
}
