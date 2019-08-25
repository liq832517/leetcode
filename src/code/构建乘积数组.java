package code;

public class 构建乘积数组 {
    public static int[] multiply(int[] A) {

        if (A.length==0){
            return A;
        }

        int len=A.length;
        int[]B=new int[len];
        B[0]=1;
        int temp=1;
        for (int i = 1; i <len ; i++) {
            B[i]=B[i-1]*A[i-1];
        }
        for (int i = 4; i >0 ; i--) {
            temp*=A[i];
            B[i-1]=temp*B[i-1];
        }
        for (int i = 0; i <len ; i++) {
            System.out.println(B[i]);
        }

        return B;
    }
   public static void main(String[]args){
        multiply(new int[]{1,-2});
   }
}
