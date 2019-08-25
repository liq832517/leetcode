package code;

import java.util.ArrayList;

public class 和为S的两个数字 {
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {

        int i=0,j=array.length-1;
        int high=0,low=0;
        int cur=0;
        for (; i<j ; ) {
            if (array[i]+array[j]==sum){
                cur=array[high]*array[low];break;
            }else if(array[i]+array[j]<sum){
                i++;
            }else if (array[i]+array[j]>sum){
                j--;
            }
        }
        ArrayList<Integer>arrayList=new ArrayList<>();
        if (cur==0)
            return arrayList;
        arrayList.add(array[low]);
        arrayList.add(array[high]);
        return arrayList;

    }
}
