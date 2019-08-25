package leetcode;

import java.util.Scanner;

public class 零钱兑换 {
    public static int change(int amount, int[] coins,int []vcoins) {

        if(amount<=0||coins.length<=0)
            return 0;
        int n=coins.length;
        int[][] dp=new int[n][amount+1];
        for (int i = 0; i <n ; i++) {//初始化第一行
            dp[i][0]=1;
        }
        for (int i = 1; i <=amount ; i++) {//初始化第一列
            if(i%coins[0]==0)
                dp[0][i]=1;
            else dp[0][i]=0;
        }
        for (int i = 1; i <n ; i++) {
            for (int j = 1; j <=amount ; j++) {
                if(j>=coins[i])
                    dp[i][j]=dp[i-1][j]+dp[i][j-coins[i]];
                else dp[i][j]=dp[i-1][j];
            }
        }
        return dp[n-1][amount];

    }
   
    public static void main(String[]args){
        Scanner scanner=new Scanner(System.in);
        int n1=scanner.nextInt();
        int n2=scanner.nextInt();
        int m=scanner.nextInt();
        int []a=new int[n1];
        int []b=new int[n2];
        for (int i = 0; i <n1 ; i++) {
            a[i]=scanner.nextInt();
        }
        for (int i = 0; i <n2 ; i++) {
            b[i]=scanner.nextInt();
        }

        int x=change(10,a,b);
        System.out.println(x);
    }
}
