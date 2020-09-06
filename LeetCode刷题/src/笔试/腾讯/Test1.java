package 笔试.腾讯;

import java.util.Scanner;

public class Test1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int l1 = in.nextInt();
            int[] val1 = new int[l1];
            for (int i = 0; i < l1; i++) {
                val1[i] = in.nextInt();
            }
            //第二个链表
            int l2 = in.nextInt();
            int[] val2 = new int[l2];
            for (int i = 0; i < l2; i++) {
                val2[i] = in.nextInt();
            }
            StringBuilder sb = new StringBuilder();
            int i = 0,j = 0;
            while(i < l1 && j < l2){
                if(val1[i] < val2[j]){
                    j++;
                }else if(val1[i] > val2[j]){
                    i++;
                }else{
                    //相等
                    sb.append(val1[i]).append(" ");
                    i++;
                    j++;
                }
            }
            System.out.println(sb.toString().trim());
        }
    }
}
