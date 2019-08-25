package code;

/*给定一个无序数组，包含正数、负数和0，要求从中找出3个数的乘积，使得乘积最大，要求时间复杂度：O(n)，空间复杂度：O(1)
        输入描述:
        无序整数数组A[n]

        输出描述:
        满足条件的最大乘积

        输入例子1:
        3 4 1 2

        输出例子1:
        24

        最大乘积为最大的三个数字乘积或者最大一个数字和最小两个数字乘积，负负得正。

        注意此题需要用long*/
public class 拼多多笔试_最大乘积 {
    public static long mutiply(int a[]){
        if (a==null)
            return -1;
        int pos1=0,pos2=0,neg1=0,neg2=0,maxNum=0;//
        for (int i = 0; i <a.length ; i++) {
            if(a[i]>0){
                if (a[i]>maxNum){
                    pos2=pos1;
                    pos1=maxNum;
                    pos1=Math.max(pos1,pos2);
                    pos2=Math.min(pos1,pos2);
                    maxNum=a[i];
                }
                else if(a[i]>Math.min(pos1,pos2)){
                    pos2=pos1;
                    pos1=a[i];
                    pos1=Math.max(pos1,pos2);
                    pos2=Math.min(pos1,pos2);
                }
            }
            if (a[i]<0){
                if (a[i]<Math.max(neg1,neg2)){
                    neg2=neg1;
                    neg1=a[i];
                    neg1=Math.min(neg1,neg2);
                    neg2=Math.max(neg1,neg2);
                }
            }
        }
        int temp=neg1*neg2>pos1*pos2?neg1*neg2:pos1*pos2;
        return maxNum*temp;
    }
    public static void main(String[]args){
        System.out.println( mutiply(new int[]{2,-1,-3,10,0,4,6,-9}));
    }
}
