package code;

public class 矩阵中的路径 {
    public static boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
        boolean[]flag=new boolean[matrix.length];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(helper(matrix,rows,cols,i,j,0,str,flag))
                    return true;
            }
        }
        return false;
    }
    private static boolean helper(char[]matrix,int rows,int cols,int i,int j,int k,char[]str,boolean[]flag){
        int index=i*cols+j;
        if(k==str.length-1)return true;
        if(i>=rows||i<0||j<0||j>=cols||matrix[index]!=str[k]||flag[index]==true)//不满足条件：越界/当前位置不等与匹配位置/已访问过
            return false;
        flag[index]=true;//满足，标记为已访问过
        if(helper(matrix,rows,cols,i+1,j,k+1,str,flag)//右
                ||helper(matrix,rows,cols,i,j+1,k+1,str,flag)//下
                ||helper(matrix,rows,cols,i-1,j,k+1,str,flag)//左
                ||helper(matrix,rows,cols,i,j-1,k+1,str,flag)) //上
            return true;

        flag[index]=false;//匹配失败
        return false;
    }
    public static void main(String[]args){
        boolean x=hasPath((
                "ABCEHJIG" +
                "SFCSLOPQ" +
                "ADEEMNOE" +
                "ADIDEJFM" +
                "VCEIFGGS").toCharArray(),5,8,"SLHECCEIDEJFGGFIE".toCharArray()
        );
        System.out.println(x);
    }
}
