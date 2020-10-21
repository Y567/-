package 笔试.阅文集团;

public class Binary {

    /**
     * 找二进制数中1的个数
     */
    public static int search(int number){
        int res = 0;
        for (int i = 0; i < 32; i++) {
            if(0 != (number & (1 << i))){
                res++;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        System.out.println(search(15));
    }
}
