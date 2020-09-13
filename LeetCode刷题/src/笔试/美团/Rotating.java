package 笔试.美团;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Rotating {

    /**
     * 思路：遍历字符串看每一个字母是否可以转动，可以的话就是一种情况,过了百分之45
     * @param s 初始密码
     * @param n 几个齿轮，其实就是字符串的长度
     * @return 返回方案的数量求模
     */
    public static int getCount(String s,int n){
        if(n <= 0){
            return 0;
        }
        char[] chars = s.toCharArray();
        HashSet<String> set = new HashSet<>();
        //第一种组合
        set.add(s);
        for (int i = 0; i < n; i++) {
            char c = chars[i];
            if(i == 0){
                //开头的齿轮没第一个按钮
                if(c == 'Z'){
                    //齿轮不能移动
                    continue;
                }
                if(i + 1 < n && chars[i+1] == 'A'){
                    //有下一个齿轮,且为'A'，那么也不能移动
                    continue;
                }
                //走到就是可以移动
                chars[i] = (char) (chars[i] + 1);
                if(i +1 < n){
                    chars[i+1] = (char)(chars[i] - 1);
                }
                //一种状态
                set.add(Arrays.toString(chars));
                //恢复状态
                chars = s.toCharArray();
            }else if(i == (n-1)){
                //最后一个齿轮没第二个按钮
                if(c == 'Z'){
                    //不能动这个齿轮
                    continue;
                }
                if(chars[i-1] == 'A'){
                    //前一个不能动，所以这个按钮也不能按
                    continue;
                }
                //走到这里就说明可以按了
                chars[i] = (char) (chars[i] + 1);
                chars[i-1] = (char) (chars[i-1] - 1);
                set.add(Arrays.toString(chars));
                chars = s.toCharArray();
            }else{
                //中间的齿轮，按下的时候需要考虑前后齿轮能否转动A-Z，Z-A
                char pre = chars[i-1];
                char next = chars[i+1];
                if(c == 'Z'){
                    //不能转
                    continue;
                }
                if(pre != 'A'){
                    //可以按第一个按钮
                    //走到就是可以移动
                    chars[i] = (char) (chars[i] + 1);
                    chars[i-1] = (char)(chars[i] - 1);
                    //一种状态
                    set.add(Arrays.toString(chars));
                    //恢复状态
                    chars = s.toCharArray();
                    continue;
                }
                if(next != 'A'){
                    //可以按第二个按钮
                    //走到就是可以移动
                    chars[i] = (char) (chars[i] + 1);
                    chars[i+1] = (char)(chars[i] - 1);
                    //一种状态
                    set.add(Arrays.toString(chars));
                    //恢复状态
                    chars = s.toCharArray();
                }
            }
        }
        return set.size()%998244353;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String line = in.nextLine();
            String line2 = in.nextLine();
            System.out.println(getCount(line2,Integer.valueOf(line)));
        }
    }
}
