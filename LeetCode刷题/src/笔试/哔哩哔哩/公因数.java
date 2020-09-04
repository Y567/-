package 笔试.哔哩哔哩;

public class 公因数 {
    /**
     * 辗转相除法的递归调用求两个数的最大公约数
     * @return 递归调用，最终返回最大公约数
     */
    public static int gcd(int x, int y) {
        return y == 0 ? x : gcd(y , x % y);
    }
    /**
     * 求n个数的最大公约数
     */
    public static int ngcd(int[] L , int z) {
        if(z == 1) {
            return L[0];//真正返回的最大公约数
        }
        //递归调用，两个数两个数的求
        return gcd(L[z-1], ngcd(L,z - 1));
    }

    public static int cal_max_common_factor(int[] L){
        return ngcd(L,L.length);
    }
}
