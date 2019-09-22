package leetcode;

public class buildTreebyPreInOrder {

    public TreeNode buildTreebyPreInOrder(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) return null;
        int len = preorder.length;
        return partition(preorder, inorder, 0, len - 1, 0);
    }

    private TreeNode partition(int[] preorder, int[] inorder, int inleft, int inright, int preleft) {
        TreeNode root = new TreeNode(preorder[preleft]);
        if (inleft == inright) return root;
        int x = -1;

        for (int i = inleft; i <= inright; i++) {
            if (preorder[preleft] == inorder[i]) {
                x = i;
                break;
            }
        }

        if (inleft == x || x == -1) {
            root.left = null;
        } else {
            root.left = partition(preorder, inorder, inleft, x - 1, preleft + 1);
        }
        if (inright == x || x == -1) {
            root.right = null;
        } else {
            root.right = partition(preorder, inorder, x + 1, inright, preleft + x - inleft + 1);
        }

        return root;
    }
}
