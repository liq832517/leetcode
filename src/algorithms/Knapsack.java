package algorithms;

import java.util.Arrays;

public class Knapsack {
    private int[] v;
    private int[] w;
    private int c;//背包容量
    private int[][] m;//m(i,j)是背包容量为j，可选物品为，i，i+1，i+2，i+3,...,n 时0-1背包问题的最优值
    private boolean[] x;
    public Knapsack(int[] v,int[] w,int c){
        this.v=v;
        this.w=w;
        this.c=c;
        this.x=new boolean[v.length];
        int max = maxM(w,c);//获取j的最大值，从而通过new关键字创建m数组，在内存中维数组分配相应的存储空间
        m = new int[v.length][max+1];
    }

    private int maxM(int[] w,int c){
        int max = c;
        for(int i=1;i<w.length;i++){
            if(w[i]>c)
                max=w[i];
        }
        return max;
    }
    private void solution01(int[] v,int[] w,int c,int[][] m){
        int n =v.length-1;
        int jMax = Math.min(w[n]-1, c);
        for(int j = 0;j <= jMax;j++)
            m[n][j]=0;
        for(int j=w[n];j<=c;j++)
            m[n][j]=v[n];
        for(int i=n-1;i>1;i--){
            jMax=Math.min(w[i]-1,c);
            for(int j=0;j<=jMax;j++)
                m[i][j]=m[i+1][j];
            for(int j=w[i];j<=c;j++)
                m[i][j]=Math.max(m[i+1][j], m[i+1][j-w[i]]+v[i]);
        }
        if(c>=w[1])//对于i=1时的两种情况
            m[1][c]=Math.max(m[2][c], m[2][c-w[1]]+v[1]);
        else
            m[1][c]=m[2][c];
    }
    private  void solutionPart(int[] v,int[] w,int c,double[]p,int n) {
        sort(w, v,n);
        int i;
        for (i = 1; i <= n; i++) {
            if (w[i] <= c){
                p[i] = 1;
                c -= w[i];
            }else {
                break;
            }
        }
        if (i <= n){
            p[i] = c / w[i];
        }
    }

    private  void sort(int[] w, int[] v,int n) {
        double []t=new double[n+1];
        for(int i=1;i<=n;i++){
            t[i]=v[i]/w[i];
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n-i;j++){
                if(t[j]<t[j+1]){

                    double temp=t[j];
                    t[j]=t[j+1];
                    t[j+1]=temp;

                    int temp2=w[j];
                    w[j]=w[j+1];
                    w[j+1]=temp2;

                    int temp3=v[j];
                    v[j]=v[j+1];
                    v[j+1]=temp3;
                }
            }
        }
    }
    private void traceBack(int[][] m,int[] w,int c,boolean[] x){
        int n=w.length-1;
        for(int i=1;i<n;i++){
            if(m[i][c]!=m[i+1][c]){
                x[i]=true;
                c-=w[i];//c是全局变量
            }
        }
        x[n]=m[n][c]>0;
    }
    public static void main(String[] args) {
        int v[] = {0, 2, 1, 4, 3};
        int w[] = {0, 1, 4, 2, 3};
        int c = 8;
        Knapsack knapsack = new Knapsack(v, w, c);

        System.out.println("------01背包问题-------");
        knapsack.solution01(knapsack.v, knapsack.w, knapsack.c, knapsack.m);
        System.out.println("装入背包中物品总价值最大为：");
        System.out.println(knapsack.m[1][c]);
        knapsack.traceBack(knapsack.m, knapsack.w, knapsack.c, knapsack.x);
        System.out.println("装入的物品的序号为：");
        for(int i=0;i<=v.length-1;i++){
            if(knapsack.x[i])
                System.out.print(i+" ");
        }
        System.out.println("\n------部分背包问题-------");
        double[] p = new double[v.length];
        int n=v.length-1;
        knapsack.solutionPart(v,w,c,p,n);
        System.out.println("排序后的物体的重量:");
        for(int i=1;i<=n;i++){
            System.out.print(w[i]+"\t");
        }
        System.out.println();


        System.out.println("排序后的物体的价值:");
        for(int i=1;i<=n;i++){
            System.out.print(v[i]+"\t");
        }

        double[]t=new double[n+1];//定义一个数组表示单位重量物体的价值
        for(int i=1;i<=n;i++){
            t[i]=v[i]/w[i];
        }
//用冒泡排序对double[]t进行排序(大的在前)
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n-i;j++){
                if(t[j]<t[j+1]){
                    double temp=t[j];
                    t[j]=t[j+1];
                    t[j+1]=temp;
                }
            }
        }
        System.out.println();

        System.out.println("排好序后的单位物体的价值: ");
        for(int i=1;i<=n;i++){
            System.out.print(t[i]+"\t");
        }

        double maxValueSum=0;//用来存放背包能装下的物体的最大价值总和
        for(int i=1;i<p.length;i++){
            maxValueSum+=p[i]*v[i];
        }
        System.out.println();

        System.out.println("排序后每个物体装进背包的比例:");
        for(int i=1;i<=n;i++){
            System.out.print(p[i]+"\t");
        }
        System.out.println();

        System.out.println("背包能装下的物体的最大价值总和为: "+maxValueSum);

    }


}