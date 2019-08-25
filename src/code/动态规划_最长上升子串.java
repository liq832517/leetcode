package code;

import java.util.Arrays;
import java.util.Scanner;

public class 动态规划_最长上升子串 {
    public static void main(String[]args){
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int[]a=new int[n];
        int[]maxLen=new int[n];
        for (int i = 0; i <n ; i++) {
            a[i]=scanner.nextInt();
        }
        Arrays.fill(maxLen,1);

        for (int i = 1; i <n ;i++) {
            for (int j = 0; j <i ; j++) {
                if (a[i]>a[j])
                    maxLen[i]=Math.max(maxLen[i],maxLen[j]+1);
            }
        }

        Arrays.sort(maxLen);
        System.out.println(maxLen[n-1]);

    }
}
