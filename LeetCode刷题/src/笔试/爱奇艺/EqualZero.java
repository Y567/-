package 笔试.爱奇艺;
import java.util.*;

public class EqualZero {


    public static TreeSet<List<Integer>> getEqualZeroList(int[] arr){
        //先排一波序，保证第一个有序
        Arrays.sort(arr);
        //先暴力，下来想递归与回溯
        TreeSet<List<Integer>> set = new TreeSet<>((o1, o2) -> {
            //我们知道这个List中只有三个元素，所以去比较就是了
            if(o1.get(0) < o2.get(0)){
                return -1;
            }
            if(o1.get(0).equals(o2.get(0))){
                //进行下一个元素比较
                if(o1.get(1) < o2.get(1)){
                    return -1;
                }
                if(o1.get(1).equals(o2.get(1))){
                    //第三个元素比较
                    if(o1.get(2) < o2.get(2)){
                        return -1;
                    }
                    if(o1.get(2).equals(o2.get(2))){
                        return 0;
                    }else{
                        return 1;
                    }
                }else{
                    return 1;
                }
            }else{
                return 1;
            }
        });

        //遍历
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                for (int k = j+1; k < arr.length; k++) {
                    if((arr[i] + arr[j] + arr[k]) == 0){
                        //可以添加到集合中
                        list.add(arr[i]);
                        list.add(arr[j]);
                        list.add(arr[k]);
                        //注意引用的问题，下面清除元素后，就清除了
                        set.add(new ArrayList<>(list));
                        //保证下一次的填入
                        list.clear();
                    }
                }
            }
        }
        return set;

    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String line = in.nextLine();
            String[] s = line.split(" ");
            int[] arr = new int[s.length];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.valueOf(s[i]);
            }
            TreeSet<List<Integer>> set = getEqualZeroList(arr);
            for(List<Integer> list: set){
                StringBuilder sb = new StringBuilder();
                StringBuilder result = sb.append(list.get(0)).append(" ").append(list.get(1)).append(" ").append(list.get(2));
                System.out.println(result.toString());
            }
        }
    }
}
