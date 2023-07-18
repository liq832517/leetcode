package leetcode;

import org.junit.Test;

public class buildTreebyPreInOrder {

    @Test
    public void test() {
        inorderTraversal in = new inorderTraversal();
        System.out.println(in.inorderTraversal(buildTreebyPreInOrder(new int[]{4,1,0,2,3,6,5,7,8}, new int[]{0,1,2,3,4,5,6,7,8})));
    }

    public TreeNode buildTreebyPreInOrder(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) return null;
        int len = preorder.length;
        return partition(preorder, inorder, 0, len - 1, 0);
    }

    private TreeNode partition(int[] preorder, int[] inorder, int inleft, int inright, int preleft) {
        if (inleft > inright) return null;
        TreeNode root = new TreeNode(preorder[preleft]);
        if (inleft == inright) return root;

        for (int i = inleft; i <= inright; i++) {
            if (preorder[preleft] == inorder[i]) {
                root.left = partition(preorder, inorder, inleft, i - 1, preleft + 1);
                root.right = partition(preorder, inorder, i + 1, inright, preleft + i - inleft + 1);
                return root;
            }
        }

        return null;
    }
}
