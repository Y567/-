import java.util.PriorityQueue;

public class 数组中第K大的数字 {

    public int findKthLargest(int[] nums, int k) {
        //Java内置类优先级队列（堆）
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            if(heap.size() < k){
                //小于K的话就直接加入即可
                heap.add(nums[i]);
            }else if(heap.peek() <  nums[i]){
                heap.poll();
                heap.add(nums[i]);
            }
        }
        return heap.peek();
    }
}
