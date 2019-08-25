package code;

import java.util.*;

public class 数组中只出现一次的数字 {
    public static void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        ArrayList<String>arrayList=new ArrayList<>();
        for (int i = 0; i <array.length ; i++) {
            if(!arrayList.contains(array[i]))
                arrayList.add(String.valueOf(array[i]));
            else
                arrayList.remove(String.valueOf(array[i]));
        }
       int i=0;
        if (arrayList.size()!=0){
            num1[0]=Integer.valueOf(arrayList.get(0));
            num2[0]=Integer.valueOf(arrayList.get(1));
        }


        System.out.println(num1[0]);
        System.out.println(num2[0]);
    }
    public static void main(String[]args){
        FindNumsAppearOnce(new int[]{4,6,2,2,3,3,8,8,9,9,1000000,1000000},new int[1],new int[1]);
    }
}
