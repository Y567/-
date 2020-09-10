package 笔试.途虎养车;

public class 合并有序数组 {

    public static int[] arrayMerge(int[] array1,int n,int[] array2,int m){
        int[] result = new int[n+m];
        int left = 0;
        int right = m-1;
        int i = 0;
        while(left < n && right >= 0){
            while(left < n && array1[left] <= array2[right]){
                result[i++] = array1[left++];
            }
            if(left < n && array1[left] > array2[right]){
                result[i++] = array2[right--];
            }
            while(right >= 0 && array2[right] <= array1[left]){
                result[i++] = array2[right--];
            }
            if(right >= 0 && array1[left] < array2[right]){
                result[i++] = array1[left++];
            }
        }
        if(left >= n){
            //拷贝第二个数组
            for (int j = right; j >= 0; j--) {
                result[i++] = array2[j];
            }
        }else{
            for (int j = left; j < n; j++) {
                result[i++] = array1[j];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array1 = {2,3,4,5,6,7,8,9};
        int[] array2 = {6,3,1};
        int[] result = arrayMerge(array1,8,array2,3);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }

    }
}
