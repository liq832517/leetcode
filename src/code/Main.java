package code;

import java.util.Scanner;
/*给你一个原始字符串，根据该字符串内每个字符出现的次数，按照ASCII码递增顺序重新调整输出。
举例！假设原始字符串为：
eeefgghhh
则每种字符出现的次数分别是：
(1).eee        3次
(2).f          1次
(3).gg         2次
(4).hhh        3次
重排输出后的字符串如下：
efghegheh
编写程序，实现上述功能。
【温馨提示】
(1).原始字符串中仅可能出现“数字”和“字母”；
(2).请注意区分字母大小写。

输入描述:
eeefgghhh
ee##g#hh# efgh
e######h# efghegh
efghegh
输出描述:
efghegheh
示例1
输入
eeefgghhh
输出
efghegheh*/
public class Main{
    public static void main(String[]args){
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int arr[]=new int[n];
        int t;
        for (int i = 0; i <n ; i++) {
            t=scanner.nextInt();
            if(t<2)
                System.out.println(scanner.nextInt());
            int n1=scanner.nextInt();
            int n0=n1;
            int n2=scanner.nextInt();
            int sub=n2-n1;
            boolean flag=true;
            for (int j =1; j <t ; j++) {
                n1=n2;
                n2=scanner.nextInt();
                if(n2-n1!=sub){
                    flag=false;
                }
            }
            arr[i]=flag?sub:n2-n0;
        }
        for (int i = 0; i <n ; i++) {
            System.out.println(arr[i]);
        }
    }
}



































    /*static boolean fun(int[][]buf,int m,int k){
        int j=0;
        int len=buf.length;
        for(int i=0;i<len;i++)
        {
            int start=buf[i][0];
            int end=buf[i][1];
            if(m>=start&&m<=end)
                j++;
            if(j==k)
                return true;

        }
        return false;
    }
    public static void main(String[]args){
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int k=scanner.nextInt();
        int[][]buf=new int[n][2];
        int min=51;
        int max=-51;
        for(int i=0;i<n;i++)
        {
            Scanner scanners=new Scanner(System.in);
            int start=scanners.nextInt();
            buf[i][0]=start;
            min=Math.min(start,min);
            int end=scanners.nextInt();
            buf[i][1]=end;
            max=Math.max(end,max);
        }

        int low=-51;
        int high=51;
        for(int i=min;i<=max;i++)
        {
            if(fun(buf,i,k))
            {
                low=i;
                break;
            }
        }

        for(int i=max;i>=min;i--)
        {
            if(fun(buf,i,k))
            {
                high=i;
                break;
            }
        }

        if(low==-51||high==51)
            System.out.println("error");
        else
            System.out.println(low+" "+high);
    }*/
