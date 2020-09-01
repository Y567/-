package 贪心;


/**
 * leetCode 376
 */
public class 摇摆序列 {
    public int wiggleMaxLength(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        if(nums.length < 2){
            return 1;
        }
        //1表示是上升的，0则是下降
        int flag = -1;
        int size = 1;
        for(int i = 0;i < nums.length-1;i++){
            if(nums[i] == nums[i+1]){
            }else if(nums[i] < nums[i+1]){
                if(flag == -1){
                    //第一次遇到上升
                    flag = 1;
                }
                if(flag == 1){
                    size++;
                    flag = 0;
                }
            }else if(nums[i] > nums[i+1]){
                if(flag == -1){
                    flag = 0;
                }
                if(flag == 0){
                    //这是下降的
                    size++;
                    flag = 1;
                }
            }
        }
        return size;
    }
}
