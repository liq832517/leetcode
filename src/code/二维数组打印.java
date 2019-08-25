package code;

public class 二维数组打印 {
    public static void main(String[]a){
        /*Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();*/
        int n=4;
        int[][]arr=new int[n][n];
        int count=0;
        for (int i = 0; i < n; i++) {
            System.out.println();
            for (int j = 0; j <n ; j++) {
                arr[i][j]=++count;
               // System.out.format("%3d",arr[i][j]);
            }
        }
        System.out.println();
        int x=0,y=n-1;//控制边界
        int up=x,left=y;
        int[]result=new int[n*n];
        int i=0,j=n-1;
        for (int k = 0; k < result.length; ) {
            if(i>=0&&j<=3&&i<=3&&j>=0){
                System.out.format("%3d",arr[i][j]);
               // System.out.print("["+i+","+j+"]");
                i++;j++;k++;
            }
            else {
                //返回原边界
                if(j>=i&&(i+j)<8){j=--left;i=0;}
                else if (j>=i&&(j+i)==8){j=0;i=1;up=1;}
                else if(i>j){j=0;i=++up;}
            }
        }



    }
}
