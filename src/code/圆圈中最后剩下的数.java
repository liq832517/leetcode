package code;

public class 圆圈中最后剩下的数 {
    public static int LastRemaining_Solution(int n, int m) {

        //LinkedList<Integer> arrayList=new LinkedList<>();
        if(n == 1){
            return 0; //这里返回下标,从0开始，只有一个元素就是剩余的元素0
        }
        else{
            return (LastRemaining_Solution(n-1,m) + m)% n; //我们传入的n是总共多少个数
        }

    }
    public static void main(String[]args){
       System.out.println( LastRemaining_Solution(6,4));
    }

}
