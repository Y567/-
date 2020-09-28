package 笔试.FiveEight;

import java.util.*;
import java.util.concurrent.*;

public class Tree {

    public class TreeNode {
      int val = 0;
      TreeNode left = null;
      TreeNode right = null;

    }

    /**
     * 思路：利用二叉树一层的节点数去添加元素个数
     * @param node TreeNode类
     * @return int整型ArrayList<ArrayList<>>
     */
    public ArrayList<ArrayList<Integer>> printNode (TreeNode node) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        while(!queue.isEmpty()){
            ArrayList<Integer> list = new ArrayList<>();
            TreeNode temp = queue.peekFirst();
            while(!queue.isEmpty()){
                TreeNode cur = queue.removeFirst();
                if(cur.val != '#'){
                    list.add(cur.val);
                }
            }

            lists.add(list);
            if(temp.left != null){
                queue.add(temp.left);
            }
            if(temp.right != null){
                queue.add(temp.right);
            }

        }
        return lists;

    }


    public static void main(String[] args) {
        ScheduledExecutorService scheduledThreadPool= Executors.newScheduledThreadPool(3);
        scheduledThreadPool.schedule(new Runnable(){
            @Override
            public void run() {
                System.out.println("延迟三秒");
            }
        }, 3, TimeUnit.SECONDS);
        scheduledThreadPool.scheduleAtFixedRate(new Runnable(){
            @Override
            public void run() {
                System.out.println("延迟 1 秒后每三秒执行一次");
            }
        },1,3,TimeUnit.SECONDS);

    }
}
