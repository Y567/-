package 笔试.FiveEight;

import java.util.*;

public class FirstMinNumber {


    /**
     * 思路：然后从1开始遍历，不等的时候输出
     * @param nums 数组
     * @return 那个数
     */
    public int firstMissingPositive (int[] nums) {
        TreeSet<Integer> sets = new TreeSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            //就为了去个重
            if(nums[i] > 0){
                sets.add(nums[i]);
            }
        }
        int j = 1;
        for(int i:sets){
            if(j != i){
                //一旦不等说明j就是答案，因为j是递增的，i可能跳着走
                return j;
            }
            j++;
        }
        if(sets.isEmpty()){
            return 1;
        }else{
            return sets.pollLast()+1;
        }
    }

    public static void main(String[] args) {

    }
}
