package code;

import java.util.ArrayList;
import java.util.List;

public class 生成括号 {

    public static List<String> generateParenthesis(int n) {
        List<String>list=new ArrayList<>();
        method(list,"",0,0,n);
        return list;
    }
    private static void method(List<String> res,String temp,int left,int right,int n){
        if(right>left||left>n||right>n){
            return;
        }
        if(left==n&&right==n){
            res.add(temp);
            return;
        }
        method(res,temp+"(",left+1,right,n);
        method(res,temp+")",left,right+1,n);
    }
    public static void main(String[]args){
        generateParenthesis(4).forEach(s->System.out.println(s));
    }

}
