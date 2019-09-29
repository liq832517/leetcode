package leetcode;

import org.junit.Test;

public class isValidBST {

    @Test
    public void test() {
        buildTreeByPostInOrder in = new buildTreeByPostInOrder();
        System.out.println(isValidBST(in.buildTreeByPostInOrder( new int[]{1,3,2},new int[]{1,2,3})));
    }
    public boolean isValidBST(TreeNode root) {

        if (root == null) return true;
        boolean leftValid = true, rightValid = true;
        if (root.right != null) leftValid= root.val < helper(root.right, false).val && isValidBST(root.right);
        if (root.left != null) rightValid= root.val > helper(root.left, true).val && isValidBST(root.left);
        return leftValid&&rightValid;
    }

    private TreeNode helper(TreeNode root, boolean isLeft) {
        if (isLeft) {
            while (root.right != null) root = root.right;
        } else {
            while (root.left != null) root = root.left;
        }
        return root;
    }
}
