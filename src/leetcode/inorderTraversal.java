package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class inorderTraversal {

    class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<Integer>();
            if (root == null) {
                return res;
            }
            Stack<TreeNode> stack = new Stack<TreeNode>();
            stack.push(root);
            TreeNode cur = root;
            while (!stack.isEmpty() || cur != null) {
                while (cur.left != null) {
                    cur = cur.left;
                    stack.push(cur);
                }
                if (!stack.isEmpty()) {
                    res.add(stack.pop().val);
                    if (cur.right != null) {
                        cur = cur.right;
                        stack.push(cur);
                    }
                }

            }
            return res;
        }
    }
}
