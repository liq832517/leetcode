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
            TreeNode cur = root;
            while (!stack.isEmpty()||cur!=null) {
                while (cur != null) {
                    stack.push(cur);
                    cur = cur.left;
                }
                cur = stack.pop();
                res.add(cur.val);
                cur = cur.right;
            }
            return res;
        }
    }
}
