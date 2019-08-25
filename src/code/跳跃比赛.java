package code;

import java.util.Scanner;
/*给出一组正整数，你从第一个数向最后一个数方向跳跃，每次至少跳跃1格，每个数的值表示你从这个位置可以跳跃的最大长度。
计算如何以最少的跳跃次数跳到最后一个数。

输入描述:
第一行表示有多少个数n
第二行开始依次是1到n个数，一个数一行
输出描述:
输出一行，表示最少跳跃的次数。*/
public class 跳跃比赛 {

    public static int jump(int[]s) {
        int n=s.length;
        if(n==0)
            return 0;
        int[]steps=new int[n];
        steps[0]=0;
        for (int i = 1; i<n; i++) {
            for (int j = 0; j<i; j++) {
                if (j+s[j] >= i) {
                    steps[i] = steps[j] + 1;
                    break;
                }
            }
        }

        return steps[n-1];
    }


    public static void main(String[]args){
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int[]num=new int[n];

        for(int i=0;i<n;i++)
        {
            num[i]=scanner.nextInt();
        }
        System.out.println(jump(num));
    }
}