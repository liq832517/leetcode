package code;

class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}
public class 二叉树的下一个节点 {
    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {

        if (pNode==null)
            return null;
        //if(pNode.next==null)
        if (pNode.right!=null)
        {
            TreeLinkNode temp=pNode.right;
            while (temp.left!=null){
                temp=temp.left;
            }
            return temp;
        }
        while (pNode.next!=null){
            TreeLinkNode temp=pNode.next;
            if(temp.left==pNode)
                return temp;
            pNode=pNode.next;
        }
        return null;

    }
}
