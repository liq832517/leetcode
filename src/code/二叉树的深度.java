package code;

import java.util.*;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }
}
public class 二叉树的深度 {
    private boolean IsBalanced=true;
    public int TreeDepth(TreeNode root) {

        if (root==null)
            return 0;
        int left,right;
        if(root.left==null&&root.right==null)
            return 1;
        if(root.left!=null&&root.right==null)
         return TreeDepth(root.left)+1;
        if (root.right!=null&&root.left==null)
         return TreeDepth(root.right)+1;
        left=TreeDepth(root.left);
        right=TreeDepth(root.right);
        return 1+left>right?left:right;
    }
    boolean isSymmetrical(TreeNode pRoot)
    {
        if((pRoot==null)||(pRoot.right==null&&pRoot.left==null))
            return true;
        if(pRoot.right!=null&&pRoot.left!=null){
            return isEqual(pRoot.left,pRoot.right);
        }
        return false;
    }
    boolean isEqual(TreeNode pleft,TreeNode pright){
        if (pleft==null&&pright==null)
            return true;
        if(pleft!=null&&pright!=null){
            if(pleft.val==pright.val)
                return isEqual(pleft.left,pright.right)&&isEqual(pleft.right,pright.left);
        }
        return false;
    }

    public ArrayList<ArrayList<Integer>> Print1(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>>arrayLists=new ArrayList<>();
        if(pRoot==null)
            return arrayLists;
        LinkedList<TreeNode> queue=new LinkedList<>();
        ArrayList<Integer>list=new ArrayList<>();
        boolean isLeftToRight=true;
        queue.addLast(null);
        queue.addLast(pRoot);
        while (queue.size()!=1){
            TreeNode temp=queue.removeFirst();
            if(temp==null){//到达层分隔符
                Iterator<TreeNode>iterator;
                if(isLeftToRight){
                    iterator=queue.iterator();
                }else {
                    iterator=queue.descendingIterator();
                }
                isLeftToRight=!isLeftToRight;
                while (iterator.hasNext()){
                    TreeNode t=iterator.next();
                    list.add(t.val);
                }
                arrayLists.add(new ArrayList<>(list));
                list.clear();
                queue.addLast(null);
                continue;
            }
            if(temp.left!=null){
                queue.addLast(temp.left);
            }
            if(temp.right!=null){
                queue.addLast(temp.right);
            }

        }
        return arrayLists;
    }
    /*从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。*/
    ArrayList<ArrayList<Integer> > Print2(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>>arrayLists=new ArrayList<>();
        if(pRoot==null)
            return arrayLists;
        Queue<TreeNode> queue=new ArrayDeque<>();
        ArrayList<Integer>list=new ArrayList<>();

        queue.add(pRoot);
        while (!queue.isEmpty()){

            int low=0;int high=queue.size();
            while (low++<high){
                TreeNode temp=queue.remove();
                list.add(temp.val);
                if(temp.left!=null){
                    queue.add(temp.left);
                }
                if(temp.right!=null){
                    queue.add(temp.right);
                }
            }
            arrayLists.add(new ArrayList<>(list));
            list.clear();

        }
        return arrayLists;
        /*ArrayList<ArrayList<Integer>>arrayLists=new ArrayList<>();
        if(pRoot==null)
            return arrayLists;
        LinkedList<TreeNode> queue=new LinkedList<>();
        ArrayList<Integer>list=new ArrayList<>();
        queue.addLast(null);
        queue.addLast(pRoot);
        while (queue.size()!=1){
            TreeNode temp=queue.removeFirst();
            if(temp==null){//到达层分隔符
                Iterator<TreeNode>iterator;
                iterator=queue.iterator();
                while (iterator.hasNext()){
                    TreeNode t=iterator.next();
                    list.add(t.val);
                }
                arrayLists.add(new ArrayList<>(list));
                list.clear();
                queue.addLast(null);
                continue;
            }
            if(temp.left!=null){
                queue.addLast(temp.left);
            }
            if(temp.right!=null){
                queue.addLast(temp.right);
            }
        }
        return arrayLists;*/
    }
    TreeNode KthNode(TreeNode pRoot, int k)
    {
        if(pRoot==null|| NodeCount(pRoot)<k)
            return null;
        int n=NodeCount(pRoot.left);
        if(n==k-1)
            return pRoot;
        else if(n<k-1)
            return KthNode(pRoot.right,k-1-n);
        else return KthNode(pRoot.left,k);

    }
    int NodeCount(TreeNode pRoot){
        if(pRoot==null)
            return 0;
        if(pRoot.right==null&& pRoot.left==null)
            return 1;
        return 1+NodeCount(pRoot.left)+NodeCount(pRoot.right);
    }

    public boolean IsBalanced_Solution(TreeNode root) {
        TreeDepth(root);
        return IsBalanced;
    }

}
