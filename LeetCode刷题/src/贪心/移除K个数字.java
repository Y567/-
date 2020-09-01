package 贪心;


import java.util.LinkedList;

/**
 * leetCode 402
 * 给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小。
 *
 * 注意:
 *
 * num 的长度小于 10002 且 ≥ k。
 * num 不会包含任何前导零。
 * 示例 1 :
 *
 * 输入: num = "1432219", k = 3
 * 输出: "1219"
 * 解释: 移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-k-digits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 移除K个数字 {
    public static String removeKdigits(String num, int k) {
        LinkedList<Integer> stack = new LinkedList<>();
        char[] chars = num.toCharArray();
        for (int i = 0;i < chars.length;i++){
            //转换为了字符串
            int t = chars[i] - '0';
            while(!stack.isEmpty() && stack.peekLast() > t && k > 0){
                //做出栈操作
                stack.pollLast();
                k--;
            }
            if(t != 0 || !stack.isEmpty()){
                stack.add(t);
            }
        }

        while(!stack.isEmpty() && k > 0){
            stack.pollLast();
            k--;
        }
        //遍历链表中的数据，得到结果
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < stack.size(); i++) {
            sb.append(stack.get(i));
        }
        if(sb.length() == 0){
            return "0";
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(removeKdigits("1432219",3));
    }
}
