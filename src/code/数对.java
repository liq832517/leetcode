package code;

import java.util.Scanner;

public class 数对 {
    public static void main(String[] args){

        Scanner scanner=new Scanner(System.in);
        int n;
                //n=scanner.nextInt();
        int k;
        int k2;
                //k=scanner.nextInt();
        n=5;k2=k=2;
        int ans=0;
        if(n<1||n>100000){
            System.out.println(0);
        }else if(k>=0&&k<=n-1){

                for (int i = k2; i <n+1 ; i++) {

                    if((i+k2)<n+1){ans+=n-i;}

                }

        }
        System.out.println(ans);
    }
}
