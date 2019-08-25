package algorithms;

import java.util.Calendar;
import java.util.Random;

public class 快速排序 {
    public static void quickSort(int []A,int p,int r){
        int q=0;
        if(p<r){
            q=Partition(A,p,r);
            quickSort(A,p,q-1);
            quickSort(A,q+1,r);
        }
    }
     public static void Swap(int []A,int i,int j){
        int temp;
        temp=A[i];
        A[i]=A[j];
        A[j]=temp;
    }
     public static int Partition(int []A,int p,int r){
        int x=A[r];
        int i=p-1;
        for (int j = p; j <r ; j++) {
            if(A[j]<=x){
                i++;
                Swap(A,i,j);
            }
        }
        Swap(A,r,i+1);
        return i+1;
    }

    public static void RandomQuickSort(int[] a, int left, int right) {
        if (left < right) {
            int p = randomPartition(a, left, right);
            RandomQuickSort(a, left, p - 1);
            RandomQuickSort(a, p + 1, right);
        }
    }

    //随机化划分
    public static int randomPartition(int[] a, int left, int right) {
        Random random=new Random();
        int r = random.nextInt(right - left) + left; //生成一个随机数，即是主元所在位置
        Swap(a, right, r); //将主元与序列最右边元素互换位置，这样就变成了之前快排的形式。
        return Partition(a, left, right); //直接调用之前的代码
    }
    public static void main(String[]args){
        Random random = new Random(Calendar.getInstance().getTimeInMillis());
        int []a=new int[10000];
        int []b=new int[10000];
        int []c=new int[]{10,2,3,4,1,7,5,6,8,9 };
        for (int i = 0; i < a.length; i++) {
            a[i] = random.nextInt(Integer.MAX_VALUE);
            b[i] = a[i];
        }



        RandomQuickSort(c, 0, c.length - 1);
        for (int i = 0; i <c.length ; i++) {
            System.out.println(c[i]);
        }

        //随机化快排
        long startTime = System.currentTimeMillis();
        RandomQuickSort(a, 0, a.length - 1);
        long endTime = System.currentTimeMillis();
        System.out.format("RandomQuickSort Finished. Cost %dms\n", endTime - startTime);//o是一个输出函数，把系统的System.out.print()简单封装了一下，打起来短一些……

        //快排
        startTime = System.currentTimeMillis();
        quickSort(b, 0, b.length - 1);
        endTime = System.currentTimeMillis();
        System.out.format("QuickSort Finished. Cost %dms\n", endTime - startTime);
        //测试有序数列下的快速排序和随机快速排序的性能
        startTime = System.currentTimeMillis();
        RandomQuickSort(a, 0, a.length - 1);
        endTime = System.currentTimeMillis();
        System.out.format("RandomQuickSort Finished. Cost %dms\n", endTime - startTime);//o是一个输出函数，把系统的System.out.print()简单封装了一下，打起来短一些……
        //快排
        startTime = System.currentTimeMillis();
        quickSort(b, 0, b.length - 1);
        endTime = System.currentTimeMillis();
        System.out.format("QuickSort Finished. Cost %dms\n", endTime - startTime);
        /*随机化快排因为要生成随机数，所以有一些性能损失，所以数据规模较小，
        数据分布均匀时普通快排效率高于随机化快排，不过随着数据规模的上升，随机快排的效率会变高。
        对于有序数列，使用随机快速排序效率更高，而且超过一定量的数据如果使用普通的快速排序就会导致栈溢出，只能使用随机快速排序
        */

    }
}
