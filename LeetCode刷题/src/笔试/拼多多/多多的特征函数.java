package 笔试.拼多多;

import java.util.HashSet;
import java.util.Scanner;

public class 多多的特征函数 {

    /**
     * @param N  正整数集合
     * @param M  特征集合数组
     * @return  返回的是具有显著特征的数字的个数
     * 思路：我们可以利用set的特性去去重
     */
    public static int getCount(int N,int[] M){
        HashSet<Integer> set = new HashSet<>();
        //暴力无脑
        for (int i = 0; i < M.length; i++) {
            int j = 1;
            int temp = 1;
            while((j = M[i]*temp) <= N){
                //当找到第一个可以被整除的后，其实就可以跳跃着找了
                if(j % M[i] == 0){
                    //说明j具有显著特征
                    set.add(j);
                    temp++;
                }
            }
        }
        return set.size();
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String firstLine = in.nextLine();
            String[] fs = firstLine.split(" ");
            int N = Integer.valueOf(fs[0]);
            //特征集合的个数
            int count = Integer.valueOf(fs[1]);
            int[] M = new int[count];
            for (int i = 0; i < count; i++) {
                M[i] = Integer.valueOf(in.nextLine());
            }
            System.out.println(getCount(N, M));
        }
    }
}
