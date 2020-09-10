package 递归与回溯;

import java.util.*;

public class 找子集_有重复元素 {

    //创建一个求子集的递归回溯算法
    public static void sub(int i,int[] nums,List<List<Integer>> lists,List<Integer> list,LinkedHashSet<List<Integer>> set){
        if(i >= nums.length){
            return;
        }
        //选择该元素
        list.add(nums[i]);
        //set中没有的时候再添加
        if(!set.contains(list)){
            lists.add(new ArrayList<>(list));
            set.add(new ArrayList<>(list));
        }
        sub(i+1,nums,lists,list,set);
        list.remove(list.size()-1);
        sub(i+1,nums,lists,list,set);
    }


    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        //使用set是为了去重
        LinkedHashSet<List<Integer>> set = new LinkedHashSet<>();
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        //需要先排个序
        Arrays.sort(nums);
        ArrayList<Integer> list = new ArrayList<>();
        //先把空集加进去
        lists.add(list);
        //调用方法
        sub(0,nums,lists,list,set);
        return lists;
    }

    public static void main(String[] args) {

    }
}
