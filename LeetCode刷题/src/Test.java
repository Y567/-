import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Test<T> {

    public boolean isIntanceOf(Object sub, T parent){
        if(sub == null){
            return false;
        }
        try{
            T temp = (T)sub;
            return true;
        }catch (ClassCastException e){
            return false;
        }
    }

    public List<Integer> getResult(List<Integer> list1,List<Integer> list2){
        //3 2 1 5 7 8
        //1 5 7 10 4 2
        HashSet<Integer> set = new HashSet<Integer>();
        ArrayList<Integer> result = new ArrayList<>();
        set.addAll(list1);
        for(int i : list2){
            if(set.contains(i)){
                result.add(i);
            }
        }
        return result;
    }


    public static void main(String[] args) {

    }
}
