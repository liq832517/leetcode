package leetcode;

import java.util.*;

public class levelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> res =new ArrayList<>();
        if(root==null) return res;
        Queue<TreeNode> queue=new ArrayDeque<>();
        queue.add(root);
        TreeNode cur;
        while (!queue.isEmpty()){
            int t=queue.size();
            List<Integer> temp=new ArrayList<>();
            for (int i = 0; i < t; i++) {
                cur=queue.poll();
                temp.add(cur.val);
                if(cur.left!=null)
                queue.add(cur.left);
                if (cur.right!=null)
                queue.add(cur.right);
            }
            res.add(temp);
        }
        return res;
    }
}
