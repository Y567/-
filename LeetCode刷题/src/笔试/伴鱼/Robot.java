package 笔试.伴鱼;

import java.util.Scanner;

public class Robot {


    //可以写一个方法，获得，i，j的个位数之和
    private static int getSum(int a, int b){
        int result = 0;
        while(a != 0 || b != 0){
            if(a != 0){
                result += a%10;
                a = a/10;
            }
            if(b != 0){
                result += b%10;
                b = b/10;
            }
        }
        return result;
    }
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 移动的次数
     * @param m int整型
     * @param n int整型
     * @param k int整型
     * @return int整型
     */
    public static int movingCount (int m, int n, int k) {
        int result = 0;
        // 双层循环遍历，查看满足条件的
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(getSum(i,j) <= k){
                    result++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(getSum(345, 567));
//        while(in.hasNext()){
//            String line = in.nextLine();
//            String[] arr = line.split(",");
//            int m = Integer.valueOf(arr[0]);
//            int n = Integer.valueOf(arr[1]);
//            int k = Integer.valueOf(arr[2]);
//            System.out.println(movingCount(m, n, k));
//        }
    }
}
