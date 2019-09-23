package leetcode;

import org.junit.Test;

public class buildTreeByPostInOrder {
    @Test
    public void test() {
        inorderTraversal in = new inorderTraversal();
        System.out.println(in.inorderTraversal(buildTreeByPostInOrder( new int[]{9, 15, 7, 20, 3},new int[]{9, 3, 15, 20, 7})));
    }

    public TreeNode buildTreeByPostInOrder(int[] postorder, int[] inorder) {
        if (postorder.length == 0 || inorder.length == 0) return null;
        int len = postorder.length;
        return partition(postorder, inorder, 0, len - 1, 0, len - 1);
    }

    private TreeNode partition(int[] postorder, int[] inorder, int inleft, int inright, int postleft, int postright) {
        if (inleft > inright) return null;
        TreeNode root = new TreeNode(postorder[postright]);
        if (inleft == inright) return root;

        for (int i = inleft; i <= inright; i++) {
            if (postorder[postright] == inorder[i]) {
                root.left = partition(postorder, inorder, inleft, i - 1, postleft, postleft + i - 1 - inleft);
                root.right = partition(postorder, inorder, i + 1, inright, i + postright - inright, postright - 1);
                return root;
            }
        }

        return null;
    }
}
