package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class postorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> res =new ArrayList<>();
        Stack<TreeNode> stack =new Stack<>();
        TreeNode cur=root;
        while (!stack.isEmpty()||cur!=null){
            while (cur != null) {
                res.add(cur.val);
                stack.push(cur);
                cur = cur.right;
            }
            cur = stack.pop().left;
        }
        Collections.reverse(res);
        return res;
    }
}
