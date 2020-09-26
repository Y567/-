package 笔试.搜狗;

import java.util.Scanner;

class Interval{
    int start;
    int end;


    @Override
    public String toString() {
        return "[" +start +
                "," + end +
                "]";
    }
}
public class Title {

    public static Interval solve(int n,int k,String str1,String str2){
        Interval res = new Interval();
        res.start = 0;
        res.end = n;
        if(n == k){
            //朋友全做对了
            for (int i = 0; i < n; i++) {
                char c1 = str1.charAt(i);
                char c2 = str2.charAt(i);
                if(c1 != c2){
                    res.end = res.end - 1;
                }else{
                    res.start = res.start + 1;
                }
            }
        }else if(k == 0){
            //朋友一道都没做对
            for (int i = 0; i < n; i++) {
                char c1 = str1.charAt(i);
                char c2 = str2.charAt(i);
                if(c1 != c2){
                    res.start = res.start + 1;
                }else{
                    res.end = res.end - 1;
                }
            }
        }else{
            //最常见的情况,不会
            //记录旺仔和朋友有几个选择是相同的
            int same = 0;
            //记录旺仔和朋友有几个选择是不同的
            int diff = 0;
            for (int i = 0; i < n; i++) {
                char c1 = str1.charAt(i);
                char c2 = str2.charAt(i);
                if(c1 != c2){
                    diff++;
                }else{
                    //在k之内都行，最低也是做对same个
                   if(same < k){
                        same++;
                    }
                }
            }
            res.start = same;
            //不同的可能都是旺仔做对了,这就是旺仔的极限，但是如果不同的数量大于k了，旺仔就得减去这个k了，因为人家朋友做对了呀
            res.end = diff > k ? diff - k : diff;

        }
        return res;
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String line = in.nextLine();
            String[] split = line.split(",");
            int N = Integer.valueOf(split[0]);
            int K = Integer.valueOf(split[1]);
            String str1 = split[2];
            String str2 = split[3];
            System.out.println(solve(N,K,str1,str2));
        }
    }
}
