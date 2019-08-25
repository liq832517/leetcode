package code;

import java.util.ArrayList;

public class 最小的k个数 {
    public static void exchangeElements(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
    public static void heapSort(int[]array){

        if (array == null || array.length <= 1) {
            return;
        }

        buildMaxHeap(array);

        for (int i = array.length - 1; i >= 1; i--) {
            exchangeElements(array, 0, i);
            maxHeap(array, i, 0);
        }
        for (int i = 0; i <array.length ; i++) {
            System.out.print(array[i]);
        }

    }
    private static void buildMaxHeap(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }

        int half = array.length / 2;
        for (int i = half; i >= 0; i--) {
            maxHeap(array, array.length, i);
        }
    }
    public static void maxHeap(int[]array,int heapsize,int index){//index为堆的根节点
        int left=index*2+1;
        int right=index*2+2;
        int largest=index;
        if(left<heapsize&&array[left]>array[index]){
            largest=left;
        }
        if(right<heapsize&&array[right]>array[largest]){
            largest=right;
        }
        if(index!=largest){
            exchangeElements(array, index, largest);
            maxHeap(array,heapsize,largest);
        }

    }
    public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer>arrayList=new ArrayList<>();

        if(input.length<=k){
            for (int i:input) {
                arrayList.add(i);
            }
        }

        int[]res=new int[k];
        for (int i = 0; i < k; i++) {
            res[i]=input[i];
        }

        buildMaxHeap(res);
        for (int i = k; i <input.length ; i++) {
            if(res[0]>input[i]){
                res[0]=input[i];
                buildMaxHeap(res);
            }
        }

        for (int i:res
             ) {
            arrayList.add(i);
        }
        return arrayList;
    }
    public static void main(String[]args){
        ArrayList arrayList=GetLeastNumbers_Solution(new int[]{11,7,23,4,9,5,6,7,8},6);
        arrayList.forEach(a->System.out.println(a));
    }
}
