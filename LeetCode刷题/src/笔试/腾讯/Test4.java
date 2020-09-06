package 笔试.腾讯;

import java.util.*;

public class Test4 {

    public static void copy(int[] little,int[] big,int index){
        for (int i = 0,j = 0; i < big.length; i++) {
            if(i != index){
                little[j++] = big[i];
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            //n的长度
            int n = in.nextInt();
            int[] arr = new int[n];
            int[] temp = new int[n-1];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }

            //输出n行
            for (int i = 0; i < n; i++) {
                copy(temp,arr,i);
                Arrays.sort(temp);
                System.out.println(temp[temp.length/2]);
           }
        }
    }
}
