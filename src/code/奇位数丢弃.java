package code;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class 奇位数丢弃 {
    public static Queue<Integer> method(Queue<Integer> a){
        int n=a.size();
        if(n==1)
            return a;
        int count=0;
        int i=0;


        Queue<Integer> result=new ArrayDeque<>();

        while (i<n){
            if(count==0){
                a.poll();count++;
            }else if(count==1) {
                result.add(a.poll());count--;
            }
            i++;
        }

        return result;
    }
    public static void main(String[]args){

        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        Queue<Integer> a=new ArrayDeque<>();
        for (int i = 0; i <n+1 ; i++) {
            a.add(i);
        }
        while (a.size()>1){
            a=method(a);
        }
        System.out.println(a.peek());
    }
}
