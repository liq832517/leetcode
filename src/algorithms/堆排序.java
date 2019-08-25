package algorithms;

public class 堆排序 {

    private static void MaxHeapify(int []a,int i,int heapSize){
        int left=(i<<1)+1,right=(i<<1)+2;
        int largest=i;
        if(left<=heapSize&&a[largest]>a[left])largest=left;
        if(right<=heapSize&&a[largest]>a[right])largest=right;
        if(largest!=i){
            Swap(a,i,largest);
            MaxHeapify(a,largest,heapSize);
        }
    }

    private static void BuildMaxHeap(int []a){
        for (int i = (a.length>>1); i >=0 ; --i) {
            MaxHeapify(a,i,a.length-1);
        }
    }
    private static void HeapIncreaseKey(int[]a,int i,int key){
        if(key<a[i]){
            System.out.println("new key is smaller than current key!");
            return;
        }

        a[i]=key;
        while (i>0&&a[i>>1]<a[i]){
            Swap(a,i,i>>1);
            i=i>>1;
        }
    }

    private static void MaxHeapInsert(int[]a,int key,int heapSize){
        heapSize++;
        a[heapSize]=Integer.MIN_VALUE;
        HeapIncreaseKey(a,heapSize,key);
    }
    private static void BuildMaxHeapByInsert(int []a){
        int heapSize=0;
        for (int i = 1; i <a.length ; i++) {
            MaxHeapInsert(a,a[i],heapSize++);
        }
    }
    private static void HeapSort(int []a){
        BuildMaxHeap(a);
        for (int i =a.length-1; i >0 ;) {
            Swap(a,0,i);
            MaxHeapify(a,0,--i);
        }
    }
    private static void Swap(int a[],int i,int j){
        int temp;
        temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }
    public static  void main(String[]args){
        int []nums=new int[]{6,14,10,8,7,9,3,2,4,1};
        int []nums2=new int[]{6,14,10,8,7,9,3,2,4,1};

        System.out.println("使用插入方法建堆：");
        BuildMaxHeapByInsert(nums);
        for (int i: nums) {
            System.out.print(" "+i);
        }

        System.out.println("\n使用MAX-HEAPIFY方法建堆：");
        BuildMaxHeap(nums2);
        HeapSort(nums2);
        for (int i: nums2) {
            System.out.print(" "+i);
        }
    }
}
