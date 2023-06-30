package leetcode;

public class isSubStructure {
    private TreeNode entry;

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        findBroot(A, B);
        while (entry != null) {
            if (check(entry, B)) {
                return true;
            }
            TreeNode temp = entry;
            entry = null;
            findBroot(temp.left, B);
            findBroot(temp.right, B);
        }
        return false;
    }

    private void findBroot(TreeNode A, TreeNode B) {
        entry = null;
        if (A == null || B == null) return;
        if (A.val == B.val) {
            entry = A;
            return;
        }
        findBroot(A.left, B);
        findBroot(A.right, B);
    }

    private boolean check(TreeNode a, TreeNode b) {
        if (a != null && b != null) {
            return a.val == b.val && check(a.left, b.left) && check(a.right, b.right);
        } else return a != null || b == null;
    }
}
