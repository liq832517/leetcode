package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class preorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> res =new ArrayList<>();
        Stack<TreeNode> stack =new Stack<>();
        TreeNode cur=root;
        while (!stack.isEmpty()||cur!=null){
            while (cur != null) {
                res.add(cur.val);
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop().right;
        }
        return res;
    }
}
