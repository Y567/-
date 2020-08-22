public class 凑24点 {

    /**
     *
     * @param arr int整型一维数组
     * @return bool布尔型
     * 思路：递归进行加减乘除
     */
    private boolean OK = false;
    public void get24(int[] arr,int i,int result){
        if(24 == result){
            OK = true;
            return;
        }
        get24(arr,i+1,result+arr[i]);//进行下一个数据计算
        get24(arr,i+1,result-arr[i]);//进行下一个数据计算
        get24(arr,i+1,result*arr[i]);//进行下一个数据计算
        get24(arr,i+1,result/arr[i]);//进行下一个数据计算
        OK = false;
    }
    public boolean Game24Points (int[] arr) {
        // write code here
        if(arr == null || arr.length == 0){
            return false;
        }
        get24(arr,0,arr[0]);
        return OK;
    }
}
