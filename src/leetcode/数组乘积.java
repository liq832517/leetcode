package leetcode;

import java.util.ArrayList;

public class 数组乘积 {
    public static long tupleMultiply(String tuple, int n) {
        // Write your code here
        long mul=1;
        tuple=tuple.replace('(',' ');
        tuple=tuple.replace(')',' ');
        tuple=tuple.replace(',',' ');
        System.out.println(tuple);
        String[]t=tuple.trim().split("   ");
        for (String s : t) {
            mul*=Integer.parseInt(s.split(" ")[n-1]);
        }
        return mul;
    }
    public static void main(String[]args){
        System.out.println(tupleMultiply("(1,2,3),(4,5,6),(7,8,9),(-12,234,43)",1));
    }
}
