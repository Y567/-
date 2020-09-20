package 笔试.度小满金融;

import java.util.HashMap;
import java.util.Scanner;

public class Paint {

    public static int getCount(String s1,String s2){
        if(s1 == null || s1.length() == 0){
            return 0;
        }
        String[] ss1 = s1.split("");
        String[] ss2 = s2.split("");
        //拥有的资源
        HashMap<String, Integer> map = new HashMap<>();
        for (String s : ss1) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        int result = 0;
        for (int i = 0; i < ss2.length; i++) {
            String temp = ss2[i];
            if(map.getOrDefault(temp,0) != 0){
                result++;
                map.put(temp,map.get(temp)-1);
            }
        }
        return result;

    }
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String line1 = in.nextLine();
            String line2 = in.nextLine();
            System.out.println(getCount(line1, line2));
        }

    }
}
