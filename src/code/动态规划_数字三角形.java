package code;

public class 动态规划_数字三角形 {



    public static void main(String[]args){

        int[][] D=new int[5][5];//origin number
        int[] a=D[4];//maxSum
        for (int i = 0; i <5 ; i++) {
            for (int j = 0; j <=i ; j++) {
                D[i][j]=i+j;
                System.out.print(" "+D[i][j]);
            }
            System.out.println();
        }

        /*for( int i = 0;i <5; i++ )
            a[4][i] = D[4][i];*/
        for( int i = 3; i>= 0;  i-- )
            for( int j = 0; j <= i; j++ )
                a[j] = Math.max(a[j],a[j+1]) + D[i][j];
        System.out.println(a[0]);
    }
}
