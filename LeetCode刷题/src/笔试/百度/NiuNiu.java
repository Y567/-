package 笔试.百度;

import java.util.*;

public class NiuNiu {

    //把[i,j]区间内的牛数值+1，表示满足一个特性
    public static void setFlag(byte[] niu,int i,int j){
        for (int k = i; k <= j; k++) {
            niu[k]++;
        }
    }

    //求解
    public static void getGoodNiu(byte[] niu, int m){
        int niuCount = 0;
        //记录牛的位置
        StringBuilder sb = new StringBuilder();
        //遍历输出牛
        for (int i = 0; i < niu.length; i++) {
            if(niu[i] == m){
                //满足特性的牛牛
                niuCount++;
                if(i == niu.length-1){
                    sb.append(i);
                }
                else{
                    sb.append(i).append(" ");
                }
            }
        }
        System.out.println(niuCount);
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String T = in.nextLine();
        Integer count = Integer.valueOf(T);
        while(count > 0){
            count--;
            String second = in.nextLine();
            int n = Integer.valueOf(second.split(" ")[0]);
            int m = Integer.valueOf(second.split(" ")[1]);
            byte[] niu = new byte[n];
            for (int i = 0; i < m; i++) {
                //第一行是几个区间
                int rangeCount = Integer.valueOf(in.nextLine());
                for (int j = 0; j < rangeCount; j++) {
                    String s = in.nextLine();
                    String[] s1 = s.split(" ");
                    //记录左区间和右区间
                    setFlag(niu,Integer.valueOf(s1[0]),Integer.valueOf(s1[1]));
                }
            }
            getGoodNiu(niu,m);
        }
    }
}
