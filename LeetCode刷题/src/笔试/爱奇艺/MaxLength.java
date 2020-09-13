package 笔试.爱奇艺;

import java.util.HashSet;
import java.util.Scanner;

public class MaxLength {

    public static int getMaxSubStringLength(String s){
        HashSet<Character> set = new HashSet<>();
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(!set.contains(c)){
                set.add(c);
            }else{
                //说明包含了
                max = max < set.size() ? set.size() : max;
                set.clear();
            }
        }
        return max;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String line = in.nextLine();
            System.out.println(getMaxSubStringLength(line));
        }
    }
}
