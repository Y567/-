package 笔试.搜狗;

public class Money {

    public static void main(String[] args) {
        int hou = 51;//香蕉数量
        for (int i = 0; i < 25; i++) {//小于50是米数
            if(hou>25){
                hou = hou - 3;
            }else{
                hou = hou - 1;
            }
        }
        System.out.println(hou);
    }
}
