package 笔试.最右;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Transfer {

    /**
     * 转换十进制
     * @param number
     * @return
     */


    public static String getTen(String number){
        long res = 0;
        boolean zhen = true;
        char c = number.charAt(0);
        if(c == '-'){
            zhen = false;
            number = number.replace("-","");
        }
        int l = number.length();
        for (int i = 0; i < l; i++) {
            c = number.charAt(i);
            if('0' <= c && c <= '9'){
                //符合数字范围
                res += (c - '0')*(Math.pow(36,l-i-1));
            }else if('a' <= c && c <= 'z'){
                res += (c - '0' - 39)*(Math.pow(36,l-i-1));
            }else{
                //不是范围内的
                return "0";
            }
        }
        if(!zhen){
            return "-"+ res;
        }else{
            return String.valueOf(res);
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String line = in.nextLine();
            System.out.println(getTen(line));
        }
    }
}
