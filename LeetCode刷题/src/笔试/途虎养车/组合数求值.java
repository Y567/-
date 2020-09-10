package 笔试.途虎养车;

public class 组合数求值 {


    public static int combination(int r,int n){
        //次数
        int count = n - r;
        int sum = 1;
        for (int i = 1; i <= count; i++,n--) {
            sum = sum * n;
        }
        int sum1 = 1;
        for (int i = 1; i <= count; i++) {
            sum1 = sum1 * i;
        }

        return sum/sum1;
    }

    public static void main(String[] args) {
        System.out.println(combination(2,3));
    }
}
