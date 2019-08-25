package code;

public class 数组中的逆序对2 {
    public static int InversePairs(int [] array) {

        int[]copy=new int[array.length];
        for (int i = 0; i <array.length ; i++) {
            copy[i]=array[i];
        }

        int count=InversePairsCore(array,copy,0,array.length-1);
        return count;
    }
    private static int InversePairsCore(int[] array,int[] copy,int low,int high){
        if(low==high)
            return 0;
        int mid=(low+high)/2;
        int leftCount=InversePairsCore(copy,array,low,mid)%1000000007;//将copy和array的位置颠倒了，可以省略拷贝的一步
        int rightCount=InversePairsCore(copy,array,mid+1,high)%1000000007;
        int count=0;
        int i=mid,j=high,locCopy=high;
        while (j>mid&&i>=low){
            if(array[j]<array[i]){
                count+=j-mid;
                copy[locCopy--]=array[i--];
                if (count>1000000007){
                    count=count%1000000007;
                }
            }else {
                copy[locCopy--]=array[j--];
            }
        }
        for(;i>=low;i--){
            copy[locCopy--]=array[i];
        }
        for(;j>mid;j--){
            copy[locCopy--]=array[j];
        }

        return (leftCount+rightCount+count)%1000000007;
    }

    public static void main(String[]args){

        System.out.println( InversePairs(new int[]{1,2,3,4,5,6,7,0}));
    }
}
