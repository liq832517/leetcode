package code;

import java.util.ArrayList;
public class 滑动窗口的最大值 {
    public static ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        ArrayList<Integer> maxInWindows=new ArrayList<>();
        if(num==null||size<=0||num.length<size)
            return maxInWindows;
        int index;
        index=maxInOne(num,0,size);

        maxInWindows.add(num[index]);

        for (int i = size; i <num.length ; ++i) {
            if(index<=i-size)
                index=maxInOne(num,index+1,size);
            if(num[index]<num[i])
                index=i;
            maxInWindows.add(num[index]);
        }
        return maxInWindows;
    }
    private static int maxInOne(int []num,int begin,int size){
        int index=begin;
        for (int i = begin+1; i < begin+size; ++i) {
            if(num[index]<num[i])
                index=i;
        }
        return index;
    }
    public static void main(String[]args){
        for (Integer integer : maxInWindows(new int[]{16,14,12,10,8,6,4}, 5)) {
            System.out.println(integer);
        }
    }
}
