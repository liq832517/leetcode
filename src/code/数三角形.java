package code;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class 数三角形 {
    static int ans=0;
    static class num{
        int x;
        int y;
        public num(int a,int b){
            x=a;
            y=b;
        }
    }
    public static void insert(List<num> temp, int n, int[][]buf, int start){
        if(temp.size()==3)
        {
            if(fun(temp))
                ans++;
            return;
        }
        if(start<n)
        {
            for(int i=start;i<n;i++)
            {

                temp.add(new num(buf[i][0],buf[i][1]));
                insert(temp,n,buf,i+1);
                temp.remove(temp.size()-1);
            }
        }
    }
    public static boolean fun(List<num>list){
        num a=list.get(0);
        num b=list.get(1);
        num c=list.get(2);

        int ab=(a.x-b.x)*(a.x-b.x)+(a.y-b.y)*(a.y-b.y);
        int ac=(a.x-c.x)*(a.x-c.x)+(a.y-c.y)*(a.y-c.y);
        int bc=(c.x-b.x)*(c.x-b.x)+(c.y-b.y)*(c.y-b.y);
        int max=Math.max(ab,Math.max(bc,ac));


        return ab+ac+bc>=2*max?true:false;

    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][]buf=new int[n][2];
        for(int i=0;i<n;i++)
        {
            buf[i][0]=scanner.nextInt();
            buf[i][1]=scanner.nextInt();
        }
        List<num>list=new ArrayList<>();
        insert(list,n,buf,0);
        System.out.println(ans);
    }
}