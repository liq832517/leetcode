package leetcode;

public class diameterOfBinaryTree {
    int max=0;
    public static void main(String[] args) {

    }
    public int diameterOfBinaryTree(TreeNode root) {
        if (root==null)return 0;
        dfs(root);
        return max;
    }
    private int dfs(TreeNode root) {
        if (root.left==null&& root.right==null) return 0;
        int leftsize = root.left==null?0:dfs(root.left)+1;
        int rightsize = root.right==null?0:dfs(root.right)+1;
        max=Math.max(max,leftsize+rightsize);

        return Math.max(rightsize,leftsize);

    }
}
