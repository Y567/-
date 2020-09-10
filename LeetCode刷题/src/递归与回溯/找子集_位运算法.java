package 递归与回溯;

import java.util.ArrayList;
import java.util.List;

public class 找子集_位运算法 {



    public static List<List<Integer>> subsets(int[] nums) {
        //所有的集合个数
        int allSet = 1<<nums.length;
        ArrayList<List<Integer>> lists = new ArrayList<List<Integer>>();
        for (int i = 0; i < allSet; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = 0; j < nums.length; j++)
                if ((i&(1<<j)) != 0) {
                    list.add(nums[j]);
                }
            lists.add(list);
        }
        return lists;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};

        List<List<Integer>> lists = subsets(nums);
        System.out.println(lists);
    }
}
