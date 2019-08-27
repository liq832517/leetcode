package code;

//作业帮面试题，对一个无序数组实现奇数在前偶数在后，同时分别升序排列
public class 奇偶数组排序 {
    public static void solution(int []arr,int low, int high){
        int i=low;
        int j=high;
        while (i<j){
            while (arr[j]%2 != 1&&i<j){
                j--;
            }
            while (arr[i]%2 != 0&&i<j){
                i++;
            }
            if(low != i) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }//实现了奇偶分离，基准点为最后一个奇数

        quickSort(arr,low,i);
        quickSort(arr,i+1,high);
    }

    public static void quickSort(int[] arr, int low, int high){
        if (low >= high)return;
        int i=low;
        int j=high;

        while (i<j){
            while (arr[j]>= arr[low]&&i<j){
                j--;
            }
            while (arr[i]<=arr[low]&&i<j){
                i++;
            }
            if(i!=j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        if(low != i){
            int temp = arr[i];
            arr[i] = arr[low];
            arr[low] = temp;
        }
        quickSort(arr,low, i-1);
        quickSort(arr,i+1,high);
    }
    public static void main(String[] args){
        int[] solution = new int[]{1, 8, 6, 2, 3, 5};
        solution(solution, 0, 5);
        for (int i : solution) {
            System.out.println(i);
        }
    }
}
