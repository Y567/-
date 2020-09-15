package 笔试.奇安信;


public class Candies {


    public static void setCoin(int[] coin,int left,int right){
        for (int i = left; i <= right; i++) {
            //全部设置为宝儿姐的糖果
            coin[i] = 0;
        }
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * M包糖果，抛M次硬币，硬币连续n次为正面，最多能得到多少颗糖果
     * @param candies int整型一维数组 每包糖果的数量
     * @param coin int整型一维数组 抛硬币的结果
     * @param n int整型 连续是正面的次数
     * @return int整型
     */
    public static int maxCandies (int[] candies, int[] coin, int n) {
        //思路：将糖果数组中连续n个最大和的子序列让宝儿姐拿到
        int sum = 0;
        if(n >= candies.length){
            for (int candy : candies) sum += candy;
            return sum;
        }
        int max = 0;
        int l = 0;
        int r = 0;
        for (int left = 0; left < candies.length - n + 1; left++) {
            int right = left + n - 1;
            int sumSub = 0;
            for (int j = left; j <= right; j++) {
                //这里我们只考虑糖果是迪普的情况，因为有的糖果本来就属于宝儿姐
                if(coin[j] == 1){
                    sumSub += candies[j];
                }
            }
            if(sumSub > max){
                max = sumSub;
                //找到更大的糖果了
                //记录下标
                l = left;
                r = right;
            }
        }
        //出来就知道区间了
        setCoin(coin,l,r);
        //开始计算糖果
        for (int i = 0; i < candies.length; i++) {
            if(coin[i] == 0){
                //是宝儿姐的糖果
                sum += candies[i];
            }
        }
        return sum;
    }


    public static void main(String[] args) {
        int[] candies = {3,5,7,2,8,8,15,3};
        int[] coin = {1,0,1,0,1,0,1,0};
        System.out.println(maxCandies(candies,coin,3));
    }
}
