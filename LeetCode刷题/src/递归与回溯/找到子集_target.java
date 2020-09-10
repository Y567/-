package 递归与回溯;

import com.sun.deploy.panel.CacheSettingsDialog;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;


/**
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的每个数字在每个组合中只能使用一次。
 *
 * 说明：
 *
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 *
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 * 示例 2:
 *
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 所求解集为:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 找到子集_target {

    //sub子集
    public static void sub(int i, int[] nums, int sum,List<List<Integer>> lists, List<Integer> list, LinkedHashSet<List<Integer>> set,int target){
        if(i >= nums.length || sum > target){
            return;
        }
        sum += nums[i];
        list.add(nums[i]);
        if(sum == target && !set.contains(new ArrayList<>(list))){
            lists.add(new ArrayList<>(list));
            set.add(new ArrayList<>(list));
        }
        sub(i+1,nums,sum,lists,list,set,target);
        sum -= nums[i];
        list.remove(list.size()-1);
        sub(i+1,nums,sum,lists,list,set,target);
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(candidates);
        LinkedHashSet<List<Integer>> set = new LinkedHashSet<>();
        sub(0,candidates,0,lists,list,set,target);
        return lists;
    }
}
