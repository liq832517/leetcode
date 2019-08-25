package algorithms;

import java.util.ArrayList;
import java.util.List;

public class Node {
    String key;   // 节点关键字
    int value;   // 节点值
    Node left;   // 左节点
    Node right;  // 右节点
    Node parent; // 父节点
    static List<Node> tree = new ArrayList<Node>();

    public Node(String key,int value){
        this.key = key;
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public String toString(){
        StringBuffer buf = new StringBuffer();
        buf.append("key:"+this.key+"  ");
        if(this.left!=null){
            buf.append(" left:"+this.left.key+":"+this.left.value);
        } else {
            buf.append(" left:"+"null");
        }

        if(this.right!=null){
            buf.append(" right:"+this.right.key+":"+this.right.value);
        } else {
            buf.append(" right:"+"null");
        }

        if(this.parent!=null){
            buf.append(" parent:"+this.parent.key+":"+this.parent.value);
        } else {
            buf.append(" parent:"+"null");
        }
        return buf.toString();
    }

    // 生成默认的节点
    public static Node getInstance(){
        return new Node("",0);
    }

    // 获得根节点
    public static Node getRoot(){
        Node node = tree.get(0);
        return node;
    }

    // 遍历节点
    public static void inorder_tree_walk(Node x){
        if(x!=null){
            inorder_tree_walk(x.left);
            System.out.println(x.value);
        }
        if(x!=null){
            inorder_tree_walk(x.right);
        }
    }

    // 插入节点
    public static void insert_node(Node z){
        Node y = null;
        if(tree.size()==0){
            // 初始情况,插入根节点
            z.parent = null;
            tree.add(z);
        } else {
            // 获得根节点
            Node x = tree.get(0);
            while(x!=null){
                y = x;
                if(z.value<x.value){
                    x = x.left;
                } else {
                    x = x.right;
                }
            }
        }

        if(y!=null){
            if(z.value<y.value){
                y.left = z;
            } else {
                y.right = z;
            }
            z.parent = y;
            tree.add(z);
        }
    }

    // 获得树的最小值
    public static Node tree_minnum(){
        Node result = Node.getInstance();
        Node left   = getRoot().left;
        while(left!=null){
            result = left;
            left = left.left;
        }
        return result;
    }

    // 获得树的最小值-非迭代版本
    public static Node tree_minnum(Node x){
        Node result = Node.getInstance();
        x           = tree_search(x);
        Node left   = x.left;
        if(left==null){
            result = x;
        }
        while(left!=null){
            result = left;
            left = left.left;
        }
        return result;
    }

    // 获得树的最小值
    public static Node tree_minnum_iter(Node x){
        if(x.left==null){
            return x;
        }
        Node left = x.left;
        if(left!=null){
            left = left.left;
            return tree_minnum_iter(left);
        } else {
            return left;
        }
    }

    // 获得树的最大值
    public static Node tree_maxnum(){
        Node result = Node.getInstance();
        Node right  = getRoot().right;
        while(right!=null){
            result = right;
            right  = right.right;
        }
        return result;
    }

    // 获得树的最大值
    public static Node tree_maxnum(Node x){
        Node result = Node.getInstance();
        x           = tree_search(x);
        Node right  = x.right;
        while(right!=null){
            result = right;
            right  = right.right;
        }
        return result;
    }

    // 获得树的最大值
    public static Node tree_maxnum_iter(Node x){
        if(x.right == null){
            return x;
        }
        Node right = x.right;
        if(right!=null){
            right = right.right;
            return tree_maxnum_iter(right);
        } else {
            return right;
        }
    }

    // 查询树的节点
    public static Node tree_search(Node k){
        Node x = getRoot();
        while(x!=null && k.value!=x.value){
            if(k.value<x.value){
                x = x.left;
            } else {
                x = x.right;
            }
            System.out.println(x);
        }
        return x;
    }

    // 查询树的后继
    public static Node tree_successor(Node x){
        x = tree_search(x);
        if(x.right!=null){
            return tree_minnum(x.right);
        }
        Node y = x.parent;
        while( y!=null && x== y.right){
            x = y;
            y = y.parent;
        }
        return y;
    }

    // 删除树中的某节点-不会改变tree中元素的物理介质
    public static void tree_delete(Node z){
        z = tree_search(z);
        Node y = null;
        if(z.left == null || z.right == null){
            y = z;
        } else {
            y = tree_successor(z);
        }

        Node x = null;
        if(y.left != null){
            x = y.left;
        } else {
            x = y.right;
        }

        if(x != null){
            x.parent = y.parent;
        }

        if(y.parent == null){
            // 改变根节点的元素
        } else if( y == y.parent.left) {
            y.parent.left = x;
        } else {
            y.parent.right = x;
        }

        if(y.value!=z.value){
            z.value = y.value;
        }
    }

    public static void main(String[] args){

        Node node;
        node = new Node("6",6);
        insert_node(node);

        node = new Node("5",5);
        insert_node(node);

        node = new Node("8",8);
        insert_node(node);

        node = new Node("3",3);
        insert_node(node);

        node = new Node("7",7);
        insert_node(node);

        node = new Node("1",1);
        insert_node(node);

        node = new Node("2",2);
        insert_node(node);

        node = new Node("4",4);
        insert_node(node);

        node = new Node("9",9);
        insert_node(node);

        for(int i=0;i<tree.size();i++){
            System.out.println(tree.get(i));
        }



        System.out.println("=====================");
        System.out.println("min:"+tree_minnum(getRoot()).getValue());

        System.out.println("=====================");
        System.out.println("max:"+tree_maxnum(getRoot()).getValue());



        System.out.println("=====================");
        inorder_tree_walk(getRoot());

        System.out.println("=====================");

        for (int i = 1; i <10 ; i++) {
            node = new Node(""+i,i);
            tree_delete(node);
        }


        System.out.println("=====================");
        inorder_tree_walk(getRoot());
    }
}
