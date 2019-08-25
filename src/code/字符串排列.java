package code;

import java.util.*;

public class 字符串排列 {
    public static ArrayList<String> Permutation(String str){
        List<String> list=new ArrayList<>();
        if(str!=null&&str.length()>0){
            PermutationHelper(str.toCharArray(),0,list);
            Collections.sort(list);
        }
        return  (ArrayList)list;
    }
    public static void PermutationHelper(char[]res,int i,List<String> list){
        if(res.length-1==i){
            String val=String.valueOf(res);
            if(!list.contains(val)) {
                list.add(val);
            }
        }
        for (int j = i; j <res.length ; j++) {
            swap(res,i,j);
            PermutationHelper(res,i+1,list);
            swap(res,i,j);
        }
    }
    public static void swap(char[]res,int i,int j){
        char temp=res[i];
        res[i]=res[j];
        res[j]=temp;
    }
    public static void main(String[]args){
            /*Scanner scanner=new Scanner(System.in);
            String s=scanner.nextLine();*/
            String s="aba";
            ArrayList<String> a= Permutation(s);
            System.out.println(a.toString());
    }
}
