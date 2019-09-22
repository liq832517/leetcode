package leetcode;

import java.util.*;

public class zigzagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        TreeNode cur;
        boolean f = true;
        while (!queue.isEmpty()) {
            int t = queue.size();
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < t; i++) {
                cur = queue.poll();
                temp.add(cur.val);
                if (cur.left != null)
                    queue.add(cur.left);
                if (cur.right != null)
                    queue.add(cur.right);
            }
            if (!f) Collections.reverse(temp);
            f = !f;
            res.add(temp);
        }
        return res;
    }
}
