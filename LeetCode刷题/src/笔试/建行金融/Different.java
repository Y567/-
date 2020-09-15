package 笔试.建行金融;
import java.util.*;
public class Different {
    public static List<String> getDifferent(Set<String> s1, Set<String> s2){
        LinkedList<String> list = new LinkedList<>();
        for(String s:s1){
            if(!s2.contains(s)){
                list.add(s);
            }
        }
        return list;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String line1 = in.nextLine();
            String line2 = in.nextLine();
            String[] ss1 = line1.split(" ");
            HashMap<String, Integer> map = new HashMap<>();
            for(String s: ss1){
                map.put(s,map.getOrDefault(s,0)+1);
            }
            String[] ss2 = line2.split(" ");
            LinkedHashSet<String> s1 = new LinkedHashSet<>();
            LinkedHashSet<String> s2 = new LinkedHashSet<>();
            Set<String> strings = map.keySet();
            for(String s: strings){
                if(map.get(s) == 1){
                    s1.add(s);
                }
            }
            Collections.addAll(s2,ss2);
            System.out.println(getDifferent(s1,s2));
        }
    }
}
