package leetcode;

public class convertBST {
    int num = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root != null) {
            convertBST(root.right);
            root.val += num;
            num = root.val;
            convertBST(root.left);

            return root;
        }
        return null;
    }

    public static void main(String[] args) {
        buildTreebyPreInOrder buildTreebyPreInOrder=new buildTreebyPreInOrder();
        convertBST convertBST=new convertBST();
        TreeNode t=convertBST.convertBST(buildTreebyPreInOrder.buildTreebyPreInOrder(new int[]{4,1,0,2,3,6,5,7,8}, new int[]{0,1,2,3,4,5,6,7,8}));
        preorderTraversal preorderTraversal=new preorderTraversal();
        System.out.println(preorderTraversal.preorderTraversal(t));
    }


}
