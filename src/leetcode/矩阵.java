package leetcode;

import java.util.Arrays;

public class 矩阵 {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(updateMatrix(new int[][]{{0, 0, 0}, {0, 1, 0}, {1, 1, 1}})));
    }
    public static int[][] updateMatrix(int[][] mat) {

        int[][]res=new int[][]{{-1,-1,-1},{-1,-1,-1},{-1,-1,-1}};
        for(int i=0; i<mat.length; i++){
            for(int j=0; j<mat.length; j++){
                if (mat[i][j]==0) {
                    res[i][j]=0;
                    if (i>0&&res[i-1][j]==-1) {
                        res[i-1][j]=1;
                    }
                    if (i<mat.length-1&&res[i+1][j]==-1) {
                        res[i+1][j]=1;
                    }
                    if (j>0&&res[i][j-1]==-1) {
                        res[i][j-1]=1;
                    }
                    if (j<mat.length-1&&res[i][j+1]==-1) {
                        res[i][j+1]=1;
                    }
                }
            }
        }

        for(int i=0; i<mat.length; i++){
            for(int j=0; j<mat.length; j++){
                if (res[i][j]==-1) {
                    int x=Integer.MAX_VALUE;
                    if (i>0) {
                        x=Math.min(x,res[i-1][j]);
                    }
                    if (i<mat.length-1) {
                        x=Math.min(x,res[i+1][j]);
                    }
                    if (j>0) {
                        x=Math.min(x,res[i][j-1]);
                    }
                    if (j<mat.length-1&&res[i][j+1]==-1) {
                        x=Math.min(x,res[i][j+1]);
                    }
                    res[i][j]=x+1;
                }
            }
        }
        return res;
    }

}
