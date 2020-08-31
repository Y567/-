package 笔试.欢聚集团;

public class Flower {
    /**
     * 找到比输入的整数大的下一个水仙花数
     * @return long长整型
     */
    public static boolean isFlower(int n){
        //判断是否为水仙花数
        String s = String.valueOf(n);
        //这是次方数
        int pow = s.length();
        //这是结果
        int result = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int number = chars[i] - '0';
            result += Math.pow(number,pow);
        }
        return n == result;

    }
    public long nextNarcissisticNumber (int n) {
        // write code here
        n =  n + 1;
        while(true){
            //死循环往下去找
            if(isFlower(n)){
                return n;
            }
        }

    }

    public static void main(String[] args) {
        System.out.println(isFlower(153));
    }

}
