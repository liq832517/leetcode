package code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Solution {
    static ArrayList<Integer> arrayList=new ArrayList<>();

    public String PrintMinNumber(int [] numbers) {

        String res="";
        if(numbers.length==0)
            return res;
        if(numbers.length==1)
            return ""+numbers[0];
        for (int i = 0; i <numbers.length ; i++) {
            arrayList.add(numbers[i]);
        }
            Collections.sort(arrayList, new Comparator<Integer>() {
                @Override
                public int compare(Integer s1,Integer s2) {
                    String str1=s1+""+s2;
                    String str2=s2+""+s1;
                    return str1.compareTo(str2);
                }
            });
        for (int j:
             arrayList) {
            res+=j;
        }

        return res;
    }
    public static void main(String[]args){
        Solution solution=new Solution();
        System.out.println(solution.PrintMinNumber(new int[]{3,32,321,1,2,3,4,5}));
    }

}