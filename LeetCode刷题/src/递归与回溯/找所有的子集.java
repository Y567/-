package 递归与回溯;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class 找所有的子集 {


    /**
     * @param i  数组下标
     * @param nums 数组
     * @param list 子集
     * @param lists 结果集
     */
    public static void sub(int i,int[] nums,List<Integer> list,List<List<Integer>> lists){
        if(i >= nums.length){
            return;
        }
        //选择该元素的情况
        list.add(nums[i]);
        //将这种情况的链表添加进去,一定要新建一个，否则因为引用的原因会对list进行改变
        lists.add(new ArrayList<>(list));
        sub(i+1,nums,list,lists);
        //不选择该元素的情况
        list.remove(list.size()-1);
        sub(i+1,nums,list,lists);
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> lists = new LinkedList<List<Integer>>();
        List<Integer> list = new LinkedList<Integer>();
        //空集也算一个
        lists.add(list);
        sub(0,nums,list,lists);
        return lists;
    }



    public static void main(String[] args) {
        int[] nums = {1,2,3};

        List<List<Integer>> lists = subsets(nums);
        System.out.println(lists);
    }
}
