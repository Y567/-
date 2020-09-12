package 笔试.建行金融;

import java.util.Scanner;

public class DeleteSubString {

    public static String deleteSub(String s){
        String temp = s.replaceAll("COC", "");
        String result;
        result = temp.replaceAll("coc", "");
        return result;

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String s = in.nextLine();
            System.out.println(deleteSub(s));
        }
    }
}
