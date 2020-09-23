package 笔试.去哪网;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

public class Test1 {

    public static BigDecimal fun1(int begin, int count){
        BigDecimal res = new BigDecimal(1);
        while(count > 0){
            res = res.multiply(new BigDecimal(begin));
            begin--;
            count--;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int m = in.nextInt();
            int n = in.nextInt();
            if(n >= (m / 2)){
                n = m - n;
            }
            BigDecimal res = fun1(m, n);
            BigDecimal res1 = fun1(n,n);
            System.out.println(res.divide(res1));
        }
    }
}
