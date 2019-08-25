package code;

public class replaceSpace {
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        int [][]matrix=new int[2][3];

        int k=0;
        int row= matrix.length;//包含几个一维数组
        int col= matrix[0].length;//每个一维数组的长度
        for (int i = 0; i <2 ; i++) {
            System.out.println("");
            for (int j = 0; j < 2; j++) {
                matrix[i][j]=++k;
                System.out.print(matrix[i][j]);
            }
        }
        System.out.println("");
        int[][]result=new int[col][row];
        for (int i = 0; i <2 ; i++) {
            for (int j = 0; j < 2; j++) {
                result[i][j]=matrix[j][1-i];
            }
        }
        for (int i = 0; i <2 ; i++) {
            System.out.println("");
            for (int j = 0; j < 2; j++) {

                System.out.print(result[i][j]);
            }
        }




    }
}
