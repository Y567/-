package 笔试.美团;

import java.util.HashSet;
import java.util.Scanner;

public class SixNumber {

    public static int getCount(int left, int right){
        //首先要保证数字是六位数
        String s1 = String.valueOf(left);
        String s2 = String.valueOf(right);
        if(s2.length() < 6){
            return 0;
        }
        if(s2.length() > 6){
            right = 987654;
        }
        //走到这里说明right是六位数了
        if(s1.length() < 6){
            //赋值给left
            left = 123456;
        }
        int result = 0;
        for (int i = left; i <= right; i++) {
            HashSet<Character> set = new HashSet<>();
            String s3 = String.valueOf(i);
            char[] chars = s3.toCharArray();
            for(char c: chars){
                set.add(c);
            }
            if(set.size() < 6){
                //说明有一样的，直接下一个
                continue;
            }
            //六个数字都不能一样
            //一共这么多数字
            if(!((i & (2<<5)) == 0 || (i & 2<<3) == 0 || (i & 2) == 0)){
                //保证AB，CD，EF是正常的数字，开头不是0
                String s = String.valueOf(i);
                int AB = (s.charAt(0) - '0') * 10 + (s.charAt(1) - '0');
                int CD = (s.charAt(2) - '0') * 10 + (s.charAt(3) - '0');
                int EF = (s.charAt(4) - '0') * 10 + (s.charAt(5) - '0');
                if(AB + CD == EF){
                    result++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            int left = in.nextInt();
            int right = in.nextInt();
            System.out.println(getCount(left, right));
        }
    }
}
