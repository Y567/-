package 笔试.爱奇艺;

import java.util.*;

public class Multi {

    public static int getMulti(int[] arr){
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
        //暂时想不出更优解，遍历
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        Set<Integer> key = map.keySet();
        int max = 0;
        for(Integer i:key){
            if(map.get(i) > max && (arr.length / 2) < map.get(i)){
                max = i;
            }
        }
        return max;
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
            System.out.println(getMulti(arr));
        }
    }
}
