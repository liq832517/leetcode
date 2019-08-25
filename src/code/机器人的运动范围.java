package code;

public class 机器人的运动范围 {
    public static int movingCount(int threshold, int rows, int cols)
    {
        boolean[]flag=new boolean[rows*cols];
        int count=helper(rows,cols,0,0,flag,threshold);
        return count;
    }
    private static int helper(int rows,int cols,int i,int j,boolean[]flag,int threshold){

        int index=i*cols+j;
        int x=i,y=j;
        int sum=0;
        if(i>=rows||i<0||j<0||j>=cols||flag[index]==true){
            return 0;
        }
        while (x!=0){
            sum+=x%10;
            x/=10;
        }
        while (y!=0){
            sum+=y%10;
            y/=10;
        }
        flag[index]=true;//满足，标记为已访问过
        if(sum<=threshold){
            return 1+helper(rows,cols,++i,j,flag,threshold)
                    +helper(rows,cols,i,++j,flag,threshold)
                    +helper(rows,cols,--i,j,flag,threshold)
                    +helper(rows,cols,i,--j,flag,threshold);
        }
        flag[index]=false;
        return 0;
    }
    public static void main(String[]args){
        int x=movingCount(10,1,100);
        System.out.println(x);
    }
}
