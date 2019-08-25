package code;

public class 左旋转字符串 {
    public static void main(String[] args) {
        int n=2;
        String str="abcdefgh";
        String temp=str.substring(0,n);
        str=str.substring(n,str.length());
        str=str+temp;
        System.out.println(str);
    }

}
