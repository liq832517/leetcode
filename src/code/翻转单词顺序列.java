package code;

import java.util.Stack;

public class 翻转单词顺序列 {
    public static String ReverseSentence(String str) {

        if (str.trim().equals("")) return str;
        String[]res=str.split(" ");
        str="";
        Stack<String>strings=new Stack<>();
        for (int i = 0; i <res.length ; i++) {
            strings.push(res[i]);
        }
        if (!strings.empty())
        str=strings.pop();
        while (!strings.empty()){
            str=str+" "+strings.pop();
        }
        return str;

    }
    public static void main(String[]args){
        System.out.println(ReverseSentence("i am cool"));
    }
}
