package 笔试.小米;

import java.util.Scanner;

public class Key {


    public static int accessKey(String key){
        if(key.isEmpty() || key.length() < 8 || key.length() > 120){
            return 1;
        }
        //a,b,c,d最后的和必须是4
        int a = 0,b=0,c=0,d=0;
        for (int i = 0; i < key.length(); i++) {
            char k = key.charAt(i);
            if(a == 0 && '0'<=k && k<='9'){
                a = 1;
            }else if(b == 0 && 'a'<=k && k<='z'){
                b = 1;
            }else if(c == 0 && 'A'<=k && k<='Z'){
                c = 1;
            }else{
                d = 1;
            }
        }
        if(a+b+c+d == 4){
            return 0;
        }else{
            return 2;
        }
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String s = in.nextLine();
            String[] keys = s.split(" ");
            for (String key : keys) {
                System.out.println(accessKey(key));
            }
        }
    }
}
