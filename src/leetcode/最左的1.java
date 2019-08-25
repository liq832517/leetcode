package leetcode;

public class 最左的1 {
    public int getColumn(int[][] arr) {
        // Write your code here
        int col=arr[0].length;
        int row=arr.length;
        for (int j = 0; j <col ; j++) {
            for (int i = 0; i <row ; i++) {
                if(arr[i][j]!=0)
                    return j;
            }
        }
        return -1;
    }
    public static void main(String[]args){
        int x[][]=new int[3][5];
        System.out.println(x.length);
        System.out.println(x[0].length);
    }
}
