package 笔试.美团;

import java.util.Scanner;

public class Friend {

    //判断m是不是n的盆友

    /**
     *
     * @param n  朋友字符串
     * @param m  子字符串
     * @param nn 朋友字符产长度
     * @param mm 子字符串长度
     * @return 返回-1表示不是朋友，否则是下标和
     */
    public static int isFriend(char[] n,char[] m,int nn,int mm){
        if(mm > nn){
            //子的大过
            return -1;
        }
        int result = 0;
        boolean flag = false;
        int index = 0;
        for (int i = 0; i < mm; i++) {
            char c = m[i];

            while(index < nn){

                if(c == n[index++]){
                    flag = true;
                    //最后一个也找到了
                    result += index;
                    if(i == mm - 1){
                        //全部找到了
                        return result;
                    }
                    //找到了，跳出找下一个
                    break;
                }
            }
            //如果这里出来的时候，result 为-1
            if(!flag){
                //这一次没找到，
                return -1;
            }else{
                //这一次找到了，那么重置flag，方便下一次查找
                flag = false;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            String l1 = in.nextLine();
            String[] s = l1.split(" ");
            int nn = Integer.valueOf(s[0]);
            int mm = Integer.valueOf(s[1]);
            String l2 = in.nextLine();
            String l3 = in.nextLine();
            char[] n = l2.toCharArray();
            char[] m = l3.toCharArray();
            int friend = isFriend(n, m,nn,mm);
            if(friend != -1){
                System.out.println("Yes");
                System.out.println(friend);
            }else{
                System.out.println("No");
            }
        }
    }
}
