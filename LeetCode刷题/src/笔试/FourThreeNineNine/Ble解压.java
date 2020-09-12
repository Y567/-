package 笔试.FourThreeNineNine;

public class Ble解压 {

    public static String getString(String s){
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            StringBuilder number = new StringBuilder("0");
            if('0' <= c && c <= '9'){
                char n = s.charAt(i);
                while('0' <= n && n <= '9'){
                    number.append(n);
                    n = s.charAt(++i);
                }
            }else{
                sb.append(c);
            }
            int n = Integer.valueOf(number.toString());
            for (int j = 0; j < n; j++) {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {

        System.out.println(getString("10a22b3c"));
    }
}
