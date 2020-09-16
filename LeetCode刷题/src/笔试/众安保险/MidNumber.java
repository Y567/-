package 笔试.众安保险;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MidNumber {

    public static int midNumber(int[] arr){
        Arrays.sort(arr);
        if((arr.length&1)==0){
            //偶数
            return (arr[arr.length/2-1]+arr[arr.length/2])/2;
        }else{
            //奇数
            return arr[arr.length/2];
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        while(in.hasNext()){
            int n = in.nextInt();
            if(n == 0){
                break;
            }
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }
            list.add(midNumber(arr));
        }
        for(int i : list){
            System.out.println(i);
        }
    }
}
