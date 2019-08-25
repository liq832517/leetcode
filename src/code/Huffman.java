/*
public class Huffman {
    private final static int R=256;
    public static  void writeTrie(Node x){
        if(x.IsLeaf()){
            BinaryStdOut.write(true);
            BinaryStdOut.write(x.getCh());
            return;
        }
        BinaryStdOut.write(false);
        writeTrie(x.getLeft());
        writeTrie(x.getRight());
    }
    public static String[] buildCode(Node root){
        String[]st=new String[R];
        buildCode(st,root,"");
        return st;
    }
    public static void buildCode(String[]st,Node x,String s){
        if(x.IsLeaf()){
            st[x.getCh()]=s;
            return;
        }buildCode(x.getLeft());buildCode(x.getRight());
    }
    public static Node buildTrie(int[]freq){
        MinPQ<Node>pq=new MinPQ<>();
        for (char c=0;c<R;c++){
            Node x=pq.delMin();
            Node y=pq.delMin();
            Node parent=new Node('\0',x.getFreq()+y.getFreq(),x,y);
            pq.insert(parent);
        }
        return pq.delMin();

    }
    public static void Compress(){
        String s= BinaryStdIn.readString();
        char[] input=s.toCharArray();
        int[]freq=new int[R];
        for (int i = 0; i <input.length ; i++) {
            freq[input[i]]++;
        }


        Node root=buildTrie(freq);
        String []st=new String [R];
        buildCode(st,root,"");
        writeTrie(root);
        BinaryStdOut.write(input.length);
        for (int i = 0; i <input.length ; i++) {
            String code=st[input[i]];
            for (int j = 0; j <code.length() ; j++) {
                if(code.charAt(j)=='1')
                    BinaryStdOut.write(true);
                else BinaryStdOut.write(false);
            }
        }
        BinaryStdOut.close();
    }
    public static void main(String[]args){
        Compress();
    }
}
*/
