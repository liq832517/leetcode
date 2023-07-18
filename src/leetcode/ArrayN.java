package leetcode;

import java.util.LinkedList;
import java.util.Scanner;

public class ArrayN {

    public static void main(String[] args) {
        int n = 8;

        ArrayN arrayN=new ArrayN();
        arrayN.method(n);
    }

    public void method(int n){
        boolean []f=new boolean[n];
        int loop=n-1;
        int cur=2;
        f[2]=true;
        while (loop>0){
            int temp=0;
            loop--;

            while (f[cur]||temp<3) {
                if (cur<n-1){
                    cur++;
                }else {
                    cur=0;
                }
                if (!f[cur]) temp++;
            }
            f[cur]=true;
        }

        System.out.println(cur);
    }






}
