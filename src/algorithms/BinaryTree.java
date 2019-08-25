package algorithms;

public class BinaryTree {

    class Node {
        int data;
        Node left;
        Node right;
        public Node(){
        }
        public Node(int data){
            this.data = data;
        }
        public Node(int data, Node left, Node right){
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public void inOrderPrint(Node node) {
        if (node == null) {
            return;
        }
        inOrderPrint(node.left);
        System.out.print(node.data + " ");
        inOrderPrint(node.right);
    }

    public Node insert(int[] data,int start,int end){
        if(start > end){
            return null;
        }
        int mid = (start + end) / 2;
        Node current = new Node(data[mid]);
        current.left = insert(data, start,mid-1);
        current.right = insert(data,mid+1, end);
        return current;
    }


    public Node find(Node node, int value) {
        if (node == null) {
            return null;
        }

        if (node.data > value) {
            return find(node.left, value);
        } else if (node.data < value) {
            return find(node.right, value);
        } else {
            return node;
        }

    }


    public Node findMin(Node node) {
        if (node == null) {
            return null;
        } else if (node.left == null) {
            return node;
        } else {
            return findMin(node.left);
        }
    }


    public Node findMax(Node node) {
        if(node != null)
        {
            while(node.right != null)
                node = node.right;
        }
        return node;
    }


    public Node remove(Node root, int value) {
        if (root == null) {
            return root;
        }

        if (root.data > value) {
            root.left = remove(root.left, value);
        } else if (root.data < value) {
            root.right = remove(root.right, value);
        } else if (root.left != null && root.right != null){
            root.data = findMin(root.right).data;
            root.right = remove(root.right, root.data);
        } else if (root.left == null && root.right == null){
            root = null;
        } else {
            root = (root.left != null) ? root.left : root.right;
        }
        return root;
    }





    public static void main(String[] args) {
        int[] array = {2, 5, 9, 12, 14, 17, 21};

        BinaryTree tree = new BinaryTree();
        Node rootNode = tree.insert(array, 0, array.length - 1);

        Node findNode = tree.find(rootNode, 9);
        System.out.print("找到");
        System.out.println((findNode != null ? findNode.data : 0));

        System.out.print("最小值是");
        System.out.println(tree.findMin(rootNode).data);

        System.out.print("最大值是");
        System.out.println(tree.findMax(rootNode).data);

        Node deleteNode = rootNode;
        for (int i=0; i< array.length; i++) {
            deleteNode = tree.remove(deleteNode, array[i]);
            System.out.println("删除后");
            tree.inOrderPrint(deleteNode);
            System.out.println();
        }

    }

}