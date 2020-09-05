package 笔试.搜狗;

import java.util.Arrays;

public class Test1 {


    public static int numberofprize (int a, int b, int c) {
        int[] arr = {a,b,c};
        Arrays.sort(arr);
        //初始能兑换的奖品
        int result = arr[0];
        arr[1] = arr[1] - arr[0];
        arr[2] = arr[2] - arr[0];
        arr[0] = 0;
        //只要最后一种能有5个以上就可以兑换
        while((arr[1]*2+arr[2])>=5){
            //当最大的没有被兑换完的时候，一直兑换
            if(arr[1] > 1){
                //中间的数都大于1了，那么就可以兑换,默认将数据减掉1了
                result++;
                arr[1]--;
                arr[2]--;
            }else{
                //说明中间的也用完了,那么只能用同一种商品计算了,一种商品的化5个能换一个
                result+=(arr[2]/5);
                arr[2]-=5;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {2,4,4};
        System.out.println(numberofprize(arr[0],arr[1],arr[2]));
    }
}
