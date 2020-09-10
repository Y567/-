package 递归与回溯;

import java.util.ArrayList;
import java.util.List;

public class 左右括号 {

    public static void generate(String item,int left,int right,List<String> list){
        //left和right是剩下几个还可以放
        if(left == 0 && right == 0){
            list.add(item);
            return;
        }
        if(left > 0){
            //说明左边还会有
            generate(item+"(",left-1,right,list);
        }
        if(left < right){
            generate(item+")",left,right-1,list);
        }
    }

    public List<String> generateParenthesis(int n) {
        ArrayList<String> list = new ArrayList<>();
        generate("",n,n,list);
        return list;
    }

    public static void main(String[] args) {

    }
}
