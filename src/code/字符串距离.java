package code;

import java.util.Scanner;

public class 字符串距离 {

    public static int NumberOf1(int n) {
        int count = 0;
        while(n!= 0){
            count++;
            n = n & (n - 1);
        }
        return count;
    }
    public static void main(String[]args){
        Scanner scanner=new Scanner(System.in);
        String s="aaabbb";
        String t="ababab";
        int len=s.length()-t.length();
        s=s.replaceAll("a","1").replaceAll("b","0");
        t=t.replaceAll("b","0").replaceAll("a","1");
        int s1,sum=0;
        int s2=Integer.parseInt(t);
        for (int i = 0; i < len; i++) {
           s1=Integer.parseInt( s.substring(i,i+len));
           sum+=NumberOf1(s1^s2);
        }

        System.out.println(sum);
    }
}
