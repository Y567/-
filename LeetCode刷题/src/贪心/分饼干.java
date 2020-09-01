package 贪心;

import java.util.Arrays;

/**
 * leetCode 455
 */
public class 分饼干 {
    public int findContentChildren(int[] g, int[] s) {
        //我们利用贪心的思想：先对两个数组排序，然后逐个比较，满足就向后移动
        Arrays.sort(g);
        Arrays.sort(s);
        //遍历g
        int i = 0;
        //遍历s
        int j = 0;
        while(i < g.length && j < s.length){
            if(g[i]<=s[j]){
                //所以可以满足,同时向后移动
                i++;
                j++;
            }else{
                //不能满足就尝试向大饼干前进
                j++;
            }
        }
        //i其实就是最后被满足的孩子个数
        return i;
    }
}
