package 笔试.天融信;

import java.util.Scanner;

public class Sort {
    /**
     * 对字符串的char进行排序
     */

    //将它们都转换为ASCII码值进行排序
    public static void bubbleSort(char[] arr){
        //冒泡的次数
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                int a = arr[j]-'0';
                int b = arr[j+1]-'0';
                if(a > b){
                    char temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String s = in.nextLine();
            char[] arr = s.toCharArray();
            bubbleSort(arr);
            System.out.println(String.valueOf(arr));
        }

    }
}
