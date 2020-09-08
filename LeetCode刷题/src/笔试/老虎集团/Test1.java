package 笔试.老虎集团;

public class Test1 {



    //判断一个数是否是回文的
    public static boolean isPalindrome(int n){
        String N = String.valueOf(n);
        StringBuilder s = new StringBuilder(N).reverse();
        return s.toString().equals(N);
    }

    //判断是否是素数
    public static boolean isDrome(int n){
        if(n < 2){
            return false;
        }
        if(n == 2){
            return true;
        }
        if(n % 2 == 0){
            return false;
        }
        for (int i = 3; i < n/2; i++) {
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }

    /**
     *
     * @param N int整型
     * @return int整型
     */
    public static int primePalindrome (int N) {
        //一直循环，直到找到最小的
        for (int i = N;; i++) {
            if(isDrome(i) && isPalindrome(i)){
                return i;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(primePalindrome(8));
    }
}
