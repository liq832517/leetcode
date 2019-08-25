package leetcode;

import java.util.ArrayDeque;

public class 打劫房屋3 {

      class TreeNode {
          public int val;
          public TreeNode left, right;
          public TreeNode(int val) {
              this.val = val;
              this.left = this.right = null;
          }
     }
      public int houseRobber3(TreeNode root) {

          if(root==null)
              return 0;
          int []res=PostTrace(root);
          return Math.max(res[0],res[1]);

      }
      private int[] PostTrace(TreeNode root){

          int []result=new int[]{0,0};
          if(root==null)
              return result;
          int[]left=PostTrace(root.left);
          int[]right=PostTrace(root.right);
          result[0]=left[1]+right[1]+root.val;
          result[1]=Math.max(left[0],left[1])+Math.max(right[0],right[1]);

          return result;
      }
}
