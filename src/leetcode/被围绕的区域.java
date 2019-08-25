package leetcode;

public class 被围绕的区域 {
    public static void surroundedRegions(char[][] board) {
        if(board.length==0)
            return;
        int row=board.length;
        int col=board[0].length;
        boolean[][]flag=new boolean[row][col];
        for (int i = 0; i <col ; i++) {
            if(board[0][i]=='O'){
                helper(board,flag,0,i,row-1,col-1);
            }
            if(board[row-1][i]=='O'){
                helper(board,flag,row-1,i,row-1,col-1);
            }
        }
        for (int j = 0; j <row ; j++) {
            if(board[j][0]=='O'){
                helper(board,flag,j,0,row-1,col-1);
            }
            if(board[j][col-1]=='O'){
                helper(board,flag,j,col-1,row-1,col-1);
            }
        }
        for (int i = 0; i <row ; i++) {
            for (int j = 0; j < col; j++) {
                if(flag[i][j]==false&&board[i][j]=='O')board[i][j]='X';
                System.out.print(" "+board[i][j]);
            }
            System.out.println();
        }
    }
    private static void helper(char[][] board,boolean[][]flag,int i,int j,int row,int col){
        if(i<=row&&i>=0&&j<=col&&j>=0&&flag[i][j]==false){
            if(board[i][j]=='O'){
                flag[i][j]=true;
                helper(board,flag,i+1,j,row,col);
                helper(board,flag,i-1,j,row,col);
                helper(board,flag,i,j+1,row,col);
                helper(board,flag,i,j-1,row,col);
            }
        }
        return;
    }
    public static void main(String[]args){
        //char[][]n=new char[][]{"XXOXX".toCharArray(),"XOOOX".toCharArray(),"XXXOX".toCharArray(),"XOOXX".toCharArray()};
        surroundedRegions(new char[][]{});
    }
}
