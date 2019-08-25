package code;

import java.util.ArrayList;
import java.util.Collections;

public class 扑克牌顺子 {
    public static boolean isContinuous(int [] numbers) {
        if (numbers.length==0)
            return false;
        ArrayList<Integer> arrayList=new ArrayList<>();
        for (int i = 0; i <numbers.length; i++) {
            if(numbers[i]!=0)
            arrayList.add(numbers[i]);
        }
        Collections.sort(arrayList);

        int len=arrayList.size();
        int limit=4;
        for (int i = len-1; i >0 ; i--) {
            if(arrayList.get(i)-arrayList.get(0)>limit||arrayList.get(i)-arrayList.get(0)==0)
                return false;
            limit=arrayList.get(i)-arrayList.get(0);
        }
        return true;
    }
    public static void main(String[]args){
        System.out.println(isContinuous(new int[]{1,0,0,1,0}));
    }
}
