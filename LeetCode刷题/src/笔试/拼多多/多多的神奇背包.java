package 笔试.拼多多;

import java.util.Scanner;

public class 多多的神奇背包 {

    /**
     *
     * @param N  商品数
     * @param M  背包空间
     * @param ns 占用空间
     * @param ms 收益
     *
     *  思路：我们最想要的就是商品增加空间还收益为正，这种情况直接装背包
     */
    public static int getResult(int N,int M,int[] ns,int[] ms){
        int pro = 0;
        for (int i = 0; i < N; i++) {
            if(ns[i] * ms[i] < 0){
                if(ns[i] < 0){
                    //直接装背包
                    pro += ms[i];
                    //容量变大
                    M -= ns[i];
                }
            }else if(ns[i] * ms[i] == 0){
                if(ns[i] == 0){
                    if(ms[i] > 0){
                        //好事情，不占空间但是有收益
                        pro += ms[i];
                    }
                }
                if(ms[i] == 0){
                    if(ns[i] < 0){
                        //加空间
                        M -= ns[i];
                    }
                }
            }else{
                //两个数组对应位置相同符号
                M -= ns[i];
                pro += ms[i];
            }
        }
        return pro;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String firstLine = in.nextLine();
            String[] fs = firstLine.split(" ");
            int N = Integer.valueOf(fs[0]);
            int M = Integer.valueOf(fs[1]);
            //商品占用空间，为负数则增加背包
            int[] ns = new int[N];
            //商品收益,为负数则减少收益
            int[] ms = new int[M];
            for (int i = 0; i < N; i++) {
                String temp = in.nextLine();
                String[] ss = temp.split(" ");
                ns[i] = Integer.valueOf(ss[0]);
                ms[i] = Integer.valueOf(ss[1]);
            }
            System.out.println(getResult(N,M,ns,ms));
        }
    }
}
